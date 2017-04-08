//package com.example.ThinkingInJava.T_注解.C_使用apt处理注解;
//
//import java.util.Collection;
//import java.util.Collections;
//
///**
// * Created by heshixiyang on 2017/2/3.
// */
///*
//* 这是apt的工厂类，用于找到正确的注解处理器
//* */
//public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {
//    @Override
//    public Collection<String> supportedOptions() {
//        return Collections.emptySet();
//    }
//
//    //该方法用于传入所有需要在注解处理器中处理的注解的完整类路径
//    @Override
//    public Collection<String> supportedAnnotationTypes() {
//        return Collections.singleton("com.example.twenty_注解.three_使用apt处理注解.ExtractInterface");
//    }
//
//    //该方法用于返回注解处理器
//    @Override
//    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
//        return new InterfaceExtractorProcessor(annotationProcessorEnvironment);
//    }
//}
