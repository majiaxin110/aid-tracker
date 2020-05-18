//package org.hackathon.aidtracker.aop.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.hackathon.aidtracker.aop.annotation.AtLog;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import java.lang.reflect.Method;
//
//
//@Aspect
//@Component
//public class AtLogAspect {
//
//    private static final Logger logger=LoggerFactory.getLogger(AtLogAspect.class);
//
//
////    @Pointcut("@annotation(org.hackathon.aidtracker.annotation.AtLog)") //method under this annotation
////    public void logPointCut(){}
//
//  //  @Pointcut("execution(public **(..))") //any public method
//    @Pointcut("execution(* org.hackathon.aidtracker.*.*.*(..))") // any method under aidtracker package
//
//    public void logPointCut(){}
//
//    @Around("logPointCut()")
//    public Object logAround(ProceedingJoinPoint pjp){
//        try {
//            MethodSignature signature = (MethodSignature) pjp.getSignature();
//            Method method = signature.getMethod();
//            Class<?> targetClass = method.getDeclaringClass();
//
//            StringBuilder classAndMethod = new StringBuilder();
//
//            AtLog classAnnotation = targetClass.getAnnotation(AtLog.class);
//            AtLog methodAnnotation = method.getAnnotation(AtLog.class);
//
//            if (classAnnotation != null) {
//                if (classAnnotation.ignore()) {
//                    return pjp.proceed();
//                }
//                classAndMethod.append(classAnnotation.value()).append("-");
//            }
//
//            if (methodAnnotation != null) {
//                if (methodAnnotation.ignore()) {
//                    return pjp.proceed();
//                }
//                classAndMethod.append(methodAnnotation.value());
//            }
//
//            String target = targetClass.getName() + "#" + method.getName();
//
//            logger.info("marker: {} calling {}; parameter :{}", classAndMethod.toString(), target, formatObject(pjp.getArgs()));
//
//            long start = System.currentTimeMillis();
//            Object result = pjp.proceed();
//            long timeConsuming = System.currentTimeMillis() - start;
//
//            logger.info("{} finished <-- {}; return value :{};\n ---- time consuming :{}ms" ,
//                    classAndMethod.toString(), target, formatObject(result), timeConsuming);
//            return result;
//        } catch (Throwable throwable) {
//            logger.error(throwable.getMessage(), throwable);
//        }
//        return null;
//    }
//
//    private String formatObject(Object... args){
//        return "";
//    }
//}
