package com.example.testandroid.proxytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.testandroid.R;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProxyTestActivity extends Activity {
    private HashMap<String,ProxyTestInterface> interfaceCache = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proxy_text_activity_layout);
        initCacheInterface();
        testProxy(new Class[]{ProxyTestInterface.class});
    }

    private void initCacheInterface(){
        Entity_1 entity_1 = new Entity_1();
        interfaceCache.put(entity_1.getClass().getName(),entity_1);
        Entity_2 entity_2 = new Entity_2();
        interfaceCache.put(entity_2.getClass().getName(),entity_2);

    }

    private void testProxy(final Class[] classes){

        //测试非public的不同包的interface
        Class clazz = null;
        try {
            clazz=this.getClassLoader().loadClass
                    ("com.example.testandroid.proxytest.proxy2interface.ProxyTestInterface2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("ProxyTestActivity","ProxyTestInterface2 is null = "+(clazz==null));
        //end


        //$Proxy0
        Object proxyInstance = Proxy.newProxyInstance(this.getClassLoader()
                , new Class[]{ProxyTestInterface.class}
                , new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String className = proxy.getClass().getName();

                Log.d("ProxyTestActivity","Proxy class name = "+className);

                return className;
            }
        });

//        Log.d("ProxyTestActivity","proxyInstance is proxyInstance3 = "
//                +(proxyInstance instanceof ProxyTestInterface3)
//                +" ； Proxy class name = "+proxyInstance.getClass().getName());

        String str1 = ((ProxyTestInterface)proxyInstance).getProxyText(1);

        //$Proxy1
        Object proxyInstance2 = Proxy.newProxyInstance(this.getClassLoader()
                , new Class[]{ProxyTestInterface3.class}
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        String className = proxy.getClass().getName();
                        Log.d("ProxyTestActivity","2Proxy class name = "+className);

                        return className;
                    }
                });
        String str2 = ((ProxyTestInterface3)proxyInstance2).getStr();

        Log.d("ProxyTestActivity","Proxy return str1 = "+str1 + " ; str2 = "+str2);


    }

}
