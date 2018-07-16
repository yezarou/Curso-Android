#include <jni.h>
#include <string>
#include <vector>
#include <thread>

using namespace std;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_android9ed_examenandroid_MainActivity_productoVectorialCPP(JNIEnv *env,
                                                                            jobject instance,
                                                                            jfloatArray A_,
                                                                            jfloatArray B_,
                                                                            jfloatArray C_,
                                                                            jint size) {
    jfloat *A = env->GetFloatArrayElements(A_, NULL);
    jfloat *B = env->GetFloatArrayElements(B_, NULL);
    jfloat *C = env->GetFloatArrayElements(C_, NULL);

    // TODO

    for (int i = 0; i < size; i++)
        C[i] = A[i] * B[i];

    env->ReleaseFloatArrayElements(A_, A, 0);
    env->ReleaseFloatArrayElements(B_, B, 0);
    env->ReleaseFloatArrayElements(C_, C, 0);
}

void threadFunc(jfloat* A, jfloat* B, jfloat* C, jint array_size, jint nTasks, jint myId){

    int inicio = (myId * array_size) / nTasks;
    int fin = ((myId + 1) * array_size)/nTasks;

    for (int i = inicio; i < fin; i++)
        C[i] = A[i] * B[i];
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_android9ed_examenandroid_MainActivity_productoVectorialCPPThreads(JNIEnv *env,
                                                                                   jobject instance,
                                                                                   jfloatArray A_,
                                                                                   jfloatArray B_,
                                                                                   jfloatArray C_,
                                                                                   jint size,
                                                                                   jint nThreads) {
    jfloat *A = env->GetFloatArrayElements(A_, NULL);
    jfloat *B = env->GetFloatArrayElements(B_, NULL);
    jfloat *C = env->GetFloatArrayElements(C_, NULL);

    // TODO

    vector<thread> t;
    for(int i=0; i< nThreads; i++) t.push_back(thread(threadFunc,A,B,C,size,nThreads,i));
    for(auto &th:t) th.join();

    env->ReleaseFloatArrayElements(A_, A, 0);
    env->ReleaseFloatArrayElements(B_, B, 0);
    env->ReleaseFloatArrayElements(C_, C, 0);
}