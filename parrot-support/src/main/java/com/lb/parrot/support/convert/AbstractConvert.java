package com.lb.parrot.support.convert;


public abstract class AbstractConvert implements Convert{
   
	/**
	 * 优先级
	 */
    private int priority;
    
    /**
     * 转换对象
     */
    protected Class<?> clazz;
    
    public AbstractConvert(Class<?> clazz){
    	this.clazz = clazz;
    }
    
    public Class<?> getClazzType(){
    	return clazz;
    }
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int compareTo(Convert o) {
		if (o.getPriority() == getPriority()) {
            return 0;
        } else if (o.getPriority() < getPriority()) {
            return 1;
        } else {
            return -1;
        }
	} 
	
}
