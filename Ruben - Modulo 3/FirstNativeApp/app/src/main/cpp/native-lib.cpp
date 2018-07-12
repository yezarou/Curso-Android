#include <jni.h>
#include <string>
#include <vector>
#include <sstream>
#include <thread>
#include <mutex>
#include <atomic>

using namespace std;

//atomic<int> h{0};
//mutex m;
int * h;

void computa(int thid, int nth, int size) {
    int hh=0;
    //m.lock();
    for (int i = (thid*size)/nth; i < ((thid+1)*size)/nth; i++) hh++;
    //m.unlock();

    h[thid] = hh;
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_android9ed_firstnativeapp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    int size = 1000000;
    int nth = 10;
    h = new int(nth);

    // computa (size);
    vector<thread> t;
    for (int i = 0; i < nth; i++) t.push_back(thread(computa, i, nth, size));
    for(auto &th: t) th.join();
    for (int i = 1; i < nth; i++) h[0]+=h[i];

    //thread t1(computa, size);
    //t1.join();

    std::string hello = "Valor de h: ";
    stringstream ss;
    ss << hello << h[0];
    hello = ss.str();
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_android9ed_firstnativeapp_MainActivity_cierto(JNIEnv *env, jobject instance,
                                                               jintArray a_, jfloatArray b_, jint size) {
    jint *a = env->GetIntArrayElements(a_, NULL);
    jfloat *b = env->GetFloatArrayElements(b_, NULL);

    // TODO
    for (int i = 0; i < size; i++) if (a[i]<b[i])

    env->ReleaseIntArrayElements(a_, a, 0);
    env->ReleaseFloatArrayElements(b_, b, 0);
}