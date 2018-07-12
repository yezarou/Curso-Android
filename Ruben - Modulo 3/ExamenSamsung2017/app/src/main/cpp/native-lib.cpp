#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_android9ed_examensamsung2017_MainActivity_mediaDesdeC(JNIEnv *env,
                                                                       jobject instance, jfloat acc,
                                                                       jint count) {
    return acc/count;
}