//
// Created by corbera on 16/11/15.
//

#include "basicjni.h"
#include <jni.h>
#include <android/log.h>
extern "C"{
// Native method automatically discover by JNI because its name follows naming convention (a package name, class name, and method name)
jint Java_es_uma_muii_apdm_basicjni_MainActivity_nativeFunction1(JNIEnv *pEnv, jobject pObj, jint in) {
    jint aux = in*in;
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction1: in %d out %d", in, aux);
    return aux;
}

// Native method explicitly registered by native code with JNI function RegisterNatives (see JNI_OnLoad)
jfloat nativeFunction2(JNIEnv *pEnv, jobject pObj, jfloat in) {
    jfloat aux = in + in;
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction2: in %f out %f", in, aux);
    return aux;
}

// Native function called when native library is loaded. We register method "nativeFunction2" in this function.
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *pVm, void *reserved) {
    JNIEnv *penv;
    // get the JNI interface pointer from the JavaVM
    if (pVm->GetEnv((void **)&penv, JNI_VERSION_1_6)) {
        return -1;
    }
    JNINativeMethod nm;
    nm.name = "nativeFunction2";                // name of the method to register
    nm.signature = "(F)F";                      // signature of the method (descriptor of the method's input argument data type and return value data type)
    nm.fnPtr = (void *) nativeFunction2;                 // function pointer pointing to the native method
    // find the class in which we want to register the method
    jclass mainActivityClass = penv->FindClass("es/uma/muii/apdm/basicjni/MainActivity");
    // register the method in this class
    penv->RegisterNatives(mainActivityClass, &nm, 1);
    return JNI_VERSION_1_6;
}

// Access Java instace field and calling instance method from native code
void Java_es_uma_muii_apdm_basicjni_MainActivity_nativeFunction3(JNIEnv *pEnv, jobject pObj) {
    // get te class from object calling native function
    jclass cls = pEnv->GetObjectClass(pObj);
    // get the ID of instance field "privateInt"
    jfieldID fieldID = pEnv->GetFieldID(cls, "privateInt", "I");
    if (fieldID == 0) {
        __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction3: field privateInt not found");
    }
    // get the value of this instance field from native code
    jint i = pEnv->GetIntField(pObj, fieldID);
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction3: value of java field privateInt from native: %d", i);

    // get the ID of instance method "logFromJava"
    jmethodID methodID = pEnv->GetMethodID(cls, "logFromJava", "(I)V");
    if (methodID == 0) {
        __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction3: method logFromJava not found");
    }
    // call the instance method (Java) from native code
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction3: trying to call method logFromJava from native ...");
    pEnv->CallVoidMethod(pObj, methodID, i);
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction3: end");
}

// Native function with input and output string
jstring Java_es_uma_muii_apdm_basicjni_MainActivity_nativeFunction4(JNIEnv *pEnv, jobject pObj, jstring pString) {
    const jbyte *str;
    jboolean isCopy;
    jsize length;

    // get native char* from jstring
    str = (jbyte *) pEnv->GetStringUTFChars(pString, &isCopy);
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction4: print UTF8 pString: \"%s\", is copy: %d", str, isCopy);
    // release the reference
    pEnv->ReleaseStringUTFChars(pString, (const char *) str);

    const char* newStr = "Hello from Native";
    // create a new jstring UTF from a C char*
    jstring ret = pEnv->NewStringUTF(newStr);
    return ret;
}

// Native function manipulating Java arrays of primitive types
jintArray Java_es_uma_muii_apdm_basicjni_MainActivity_nativeFunction5(JNIEnv *pEnv, jobject pObj, jintArray pArray, jint size) {
    jboolean isCopy;
    // get a C int* from a jintArray
    jint* nArray = pEnv->GetIntArrayElements(pArray, &isCopy);

    int i;
    __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction5: Input array is copy: %d", isCopy);
    for (i=0; i<size; i++) {
        __android_log_print(ANDROID_LOG_DEBUG, "HOOKNative", "NativeFunction5: Input array[%d] = %d", i, nArray[i]++);
    }
    // release the reference
    pEnv->ReleaseIntArrayElements(pArray, nArray, 0);

    // create a new jintArray, get the int*, modify, release and return the jintArray back to Java code
    jintArray out = pEnv->NewIntArray(size);
    nArray = pEnv->GetIntArrayElements(out, &isCopy);
    for (i=0; i<size; i++) {
        nArray[i] = size-i;
    }
    pEnv->ReleaseIntArrayElements(out, nArray, 0);
    return out;
}
}
