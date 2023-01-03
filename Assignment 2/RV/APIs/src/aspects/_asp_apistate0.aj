package aspects;

import larva.*;
public aspect _asp_apistate0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_apistate0.initialize();
}
}
before () : (call(* *.postWorks(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_apistate0.lock){

_cls_apistate0 _cls_inst = _cls_apistate0._get_cls_apistate0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*postWorks*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*postWorks*/);
}
}
before () : (call(* *.postDoesntWork(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_apistate0.lock){

_cls_apistate0 _cls_inst = _cls_apistate0._get_cls_apistate0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*postDoesntWork*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*postDoesntWork*/);
}
}
}