package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_apistate0 implements _callable{

public static PrintWriter pw; 
public static _cls_apistate0 root;

public static LinkedHashMap<_cls_apistate0,_cls_apistate0> _cls_apistate0_instances = new LinkedHashMap<_cls_apistate0,_cls_apistate0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\sophi\\workspace\\APIs/src/output_apistate.txt");

root = new _cls_apistate0();
_cls_apistate0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_apistate0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_apistate0() {
}

public void initialisation() {
}

public static _cls_apistate0 _get_cls_apistate0_inst() { synchronized(_cls_apistate0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_apistate0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_apistate0_instances){
_performLogic_badLoginsProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_apistate0[] a = new _cls_apistate0[1];
synchronized(_cls_apistate0_instances){
a = _cls_apistate0_instances.keySet().toArray(a);}
for (_cls_apistate0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_apistate0_instances){
_cls_apistate0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_badLoginsProperty = 8;

public void _performLogic_badLoginsProperty(String _info, int... _event) {

_cls_apistate0.pw.println("[badLoginsProperty]AUTOMATON::> badLoginsProperty("+") STATE::>"+ _string_badLoginsProperty(_state_id_badLoginsProperty, 0));
_cls_apistate0.pw.flush();

if (0==1){}
else if (_state_id_badLoginsProperty==8){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*postWorks*/))){
		;
_cls_apistate0.pw .println ("Check is done and is correct");

		_state_id_badLoginsProperty = 6;//moving to state CheckCorrect
		_goto_badLoginsProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*postDoesntWork*/))){
		;
_cls_apistate0.pw .println ("Check is done and is INCORRECT");

		_state_id_badLoginsProperty = 7;//moving to state CheckIncorrect
		_goto_badLoginsProperty(_info);
		}
}
}

public void _goto_badLoginsProperty(String _info){
_cls_apistate0.pw.println("[badLoginsProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_badLoginsProperty(_state_id_badLoginsProperty, 1));
_cls_apistate0.pw.flush();
}

public String _string_badLoginsProperty(int _state_id, int _mode){
switch(_state_id){
case 8: if (_mode == 0) return "CheckAlerts"; else return "CheckAlerts";
case 6: if (_mode == 0) return "CheckCorrect"; else return "CheckCorrect";
case 7: if (_mode == 0) return "CheckIncorrect"; else return "CheckIncorrect";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}