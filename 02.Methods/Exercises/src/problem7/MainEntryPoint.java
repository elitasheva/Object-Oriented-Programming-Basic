package problem7;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainEntryPoint {

    public static void main(String[] args) {

        Field[] fields = ImmutableList.class.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }else {
            System.out.println(fields.length);
        }

        java.lang.reflect.Method[] methods = ImmutableList.class.getDeclaredMethods();
        List<java.lang.reflect.Method> methodsReturnTypes = Arrays.stream(methods).filter(m -> {
            if (!m.getReturnType().getName().contains("ImmutableList")) {
                return false;
            }

            return true;
        }).collect(Collectors.toList());

        if (methodsReturnTypes.size() < 1) {
            throw new ClassFormatException();
        }else {
            System.out.println(5);
        }

        ImmutableList list = new ImmutableList();

//        Field[] fields = ImmutableList.class.getDeclaredFields();
//        if (fields.length < 1) {
//            throw new ClassFormatException();
//        }
//
//        java.lang.reflect.Method[] methods = ImmutableList.class.getDeclaredMethods();
//        List<java.lang.reflect.Method> methodsReturnTypes = Arrays.stream(methods).filter(m -> {
//
//            int index = m.getReturnType().getName().indexOf(".");
//            String type = m.getReturnType().getName().substring(index+1);
//            if (!type.equalsIgnoreCase("ImmutableList")) {
//                return false;
//            }
//
//            return true;
//        }).collect(Collectors.toList());
//
//        if (methodsReturnTypes.size() < 1) {
//            throw new ClassFormatException();
//        }


    }
}

class ImmutableList{

    private List<Integer> collection;

    public ImmutableList() {
        this.collection = new ArrayList<>();
    }

    public List<Integer> getCollection() {

        return new ArrayList<>(this.collection);
    }

    public ImmutableList getNewList(){
        return new ImmutableList();
    }
}
