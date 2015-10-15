package com.qinxiandiqi.annotationprocessordemo.processors;

import com.qinxiandiqi.annotationprocessordemo.annotations.Complexity;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.*;
import java.util.Set;

/**
 * Created by Jianan on 2015/10/14.
 */
@SupportedAnnotationTypes("com.qinxiandiqi.annotationprocessordemo.annotations.Complexity")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ComplexityProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        File file = new File("compile.log");
        FileOutputStream os = null;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            os = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Element elem : roundEnv.getElementsAnnotatedWith(Complexity.class)) {
            Complexity complexity = elem.getAnnotation(Complexity.class);
            String message = System.currentTimeMillis() + " - annotation found in " + elem.getSimpleName()
                    + " with complexity " + complexity.value();
            try {
                os.write(message.getBytes());
                os.write("\r\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
        }

        try {
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true; // no further processing of this annotation type
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }
}
