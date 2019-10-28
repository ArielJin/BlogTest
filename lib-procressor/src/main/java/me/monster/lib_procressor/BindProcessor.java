package me.monster.lib_procressor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

import me.monster.lib_annotaion.BindView;

public class BindProcessor extends AbstractProcessor {
    public static final String pack_name = "me.monster.blogtest";

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println(" processor run !!!");

        // 生成代码的目标路径：第一个参数，包路径，第二个参数，className

        ClassName className = ClassName.get(pack_name, "BindSample$Binding");
        TypeSpec builtClass = TypeSpec.classBuilder(className) .addModifiers(Modifier.PUBLIC)
                .addMethod(MethodSpec.constructorBuilder() .addModifiers(Modifier.PUBLIC)
                        .addParameter(ClassName.get(pack_name, "BindSample"), "activity")
                        .addStatement("activity.tvHello = activity.findViewById(R.id.tv_hello)")
                        .build()) .build();
        try {
            JavaFile.builder(pack_name, builtClass).build().writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(BindView.class.getCanonicalName());
    }
}
