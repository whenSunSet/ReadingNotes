package com.example.ThinkingInJava.T_注解.C_使用apt处理注解;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 我们通过AnnotationProcessorEnvironment类来了解apt工具正在处理什么对象，然后就能获取Filer对象来创建新的文件
* ，这个对象继承于PrintWrite,使用了这个对象apt就会知道我们在创建新的文件，然后对新文件进行注释处理。
* apt工具需要一个工厂类来指明正确的处理器，然后它才能调用处理器上的process();
* */
public class InterfaceExtractorProcessor implements AnnotationProcessor {
    private final AnnotationProcessorEnvironment environment;
    private ArrayList<MethodDeclaration> methodDeclarations = new ArrayList<>();

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDeclaration : environment.getSpecifiedTypeDeclarations()) {
            ExtractInterface extractInterface = typeDeclaration.getAnnotation(ExtractInterface.class);
            if (extractInterface == null)
                break;

            for (MethodDeclaration methodDeclaration : typeDeclaration.getMethods()) {
                if (methodDeclaration.getModifiers().contains(Modifier.PUBLIC) && !(methodDeclaration.getModifiers().contains(Modifier.STATIC)))
                    methodDeclarations.add(methodDeclaration);
            }

            if (methodDeclarations.size() > 0) {
                try {
                    PrintWriter writer = environment.getFiler().createSourceFile(extractInterface.value());
                    writer.println("package " + typeDeclaration.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + extractInterface.value() + " {");
                    for (MethodDeclaration methodDeclaration : methodDeclarations) {
                        writer.print("  public  ");
                        writer.print(methodDeclaration.getReturnType() + " ");
                        writer.print(methodDeclaration.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration parameterDeclaration : methodDeclaration.getParameters()) {
                            writer.print(parameterDeclaration.getType() + " " + parameterDeclaration.getSimpleName());
                            if (++i < methodDeclaration.getParameters().size())
                                writer.print(" , ");
                        }
                        writer.println(");");
                    }
                    writer.println("}");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
