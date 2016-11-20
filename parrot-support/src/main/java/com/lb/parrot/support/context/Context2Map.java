package com.lb.parrot.support.context;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
* <p>Title: 把Context包装成Map</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class Context2Map implements Map<String, Object> {
    private Context context = null;

    public Context2Map(Context context) {
        this.context = context;
    }
    
    @Override
    public int size() {
        return notSupportMethod();
    }

    private int notSupportMethod() {
        throw getRuntimeException();
    }

    private RuntimeException getRuntimeException() {
        return new RuntimeException("This method is not supported.");
    }
    
    @Override
    public boolean isEmpty() {
        throw getRuntimeException();
    }

    @Override
    public boolean containsKey(Object key) {
        return context.get(key.toString()) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        throw getRuntimeException();
    }

    public Object get(Object key) {
        return context.get(key.toString());
    }

    public Object put(String key, Object value) {
        context.put(key, value);
        return value;
    }

    @Override
    public Object remove(Object key) {
        throw getRuntimeException();
    }


    public void putAll(Map<? extends String, ?> map) {
        Iterator<? extends Entry<? extends String, ?>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<? extends String, ?> entry = iterator.next();
            context.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        throw getRuntimeException();
    }

    @Override
    public Set<String> keySet() {
        throw getRuntimeException();
    }

    @Override
    public Collection<Object> values() {
        throw getRuntimeException();
    }

    @Override
    public Set<java.util.Map.Entry<String, Object>> entrySet() {
        throw getRuntimeException();
    }

}
