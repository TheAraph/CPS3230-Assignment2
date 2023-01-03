package aspects;

import larva.*;
public aspect _asp_loginstates0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_loginstates0.initialize();
}
}
before ( boolean LogOut) : (call(* *.setLoggedOut(..)) && args(LogOut) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginstates0.lock){

_cls_loginstates0 _cls_inst = _cls_loginstates0._get_cls_loginstates0_inst();
_cls_inst.LogOut = LogOut;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*LoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*LoggedOut*/);
}
}
before ( boolean isAlertPage) : (call(* *.setInAlertPage(..)) && args(isAlertPage) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginstates0.lock){

_cls_loginstates0 _cls_inst = _cls_loginstates0._get_cls_loginstates0_inst();
_cls_inst.isAlertPage = isAlertPage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 18/*AlertPage*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 18/*AlertPage*/);
}
}
before () : (call(* *.goodLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginstates0.lock){

_cls_loginstates0 _cls_inst = _cls_loginstates0._get_cls_loginstates0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 14/*goodLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 14/*goodLogin*/);
}
}
before () : (call(* *.badLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginstates0.lock){

_cls_loginstates0 _cls_inst = _cls_loginstates0._get_cls_loginstates0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*badLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*badLogin*/);
}
}
before ( boolean isLoginPage) : (call(* *.setInLoginPage(..)) && args(isLoginPage) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginstates0.lock){

_cls_loginstates0 _cls_inst = _cls_loginstates0._get_cls_loginstates0_inst();
_cls_inst.isLoginPage = isLoginPage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 16/*LoginPage*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 16/*LoginPage*/);
}
}
}