package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_loginstates0 implements _callable{

public static PrintWriter pw; 
public static _cls_loginstates0 root;

public static LinkedHashMap<_cls_loginstates0,_cls_loginstates0> _cls_loginstates0_instances = new LinkedHashMap<_cls_loginstates0,_cls_loginstates0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\sophi\\workspace\\Logins/src/output_loginstates.txt");

root = new _cls_loginstates0();
_cls_loginstates0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_loginstates0 parent; //to remain null - this class does not have a parent!
public static boolean isAlertPage;
public static boolean LogOut;
public static boolean isLoginPage;
int no_automata = 1;
 public int badLogins =0 ;
 public boolean isatLoginPage ;
 public boolean isatAlertPage ;
 public boolean isLoggedOut ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_loginstates0() {
}

public void initialisation() {
}

public static _cls_loginstates0 _get_cls_loginstates0_inst() { synchronized(_cls_loginstates0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_loginstates0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_loginstates0_instances){
_performLogic_badLoginsProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_loginstates0[] a = new _cls_loginstates0[1];
synchronized(_cls_loginstates0_instances){
a = _cls_loginstates0_instances.keySet().toArray(a);}
for (_cls_loginstates0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_loginstates0_instances){
_cls_loginstates0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_badLoginsProperty = 10;

public void _performLogic_badLoginsProperty(String _info, int... _event) {

_cls_loginstates0.pw.println("[badLoginsProperty]AUTOMATON::> badLoginsProperty("+") STATE::>"+ _string_badLoginsProperty(_state_id_badLoginsProperty, 0));
_cls_loginstates0.pw.flush();

if (0==1){}
else if (_state_id_badLoginsProperty==10){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*goodLogin*/))){
		badLogins =0 ;
_cls_loginstates0.pw .println ("You are now logged in. Bad logins: "+badLogins );

		_state_id_badLoginsProperty = 9;//moving to state Login
		_goto_badLoginsProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*badLogin*/))){
		badLogins ++;
_cls_loginstates0.pw .println ("Invalid login. You now have "+badLogins +"bad logins.");

		_state_id_badLoginsProperty = 10;//moving to state Logout
		_goto_badLoginsProperty(_info);
		}
}
else if (_state_id_badLoginsProperty==9){
		if (1==0){}
		else if ((_occurredEvent(_event,18/*AlertPage*/)) && (isAlertPage ==true )){
		;
_cls_loginstates0.pw .println ("You are logged in as you are on the Alert Page)");

		_state_id_badLoginsProperty = 9;//moving to state Login
		_goto_badLoginsProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*LoggedOut*/)) && (LogOut ==true )){
		;
_cls_loginstates0.pw .println ("You have just logged out)");

		_state_id_badLoginsProperty = 10;//moving to state Logout
		_goto_badLoginsProperty(_info);
		}
}
}

public void _goto_badLoginsProperty(String _info){
_cls_loginstates0.pw.println("[badLoginsProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_badLoginsProperty(_state_id_badLoginsProperty, 1));
_cls_loginstates0.pw.flush();
}

public String _string_badLoginsProperty(int _state_id, int _mode){
switch(_state_id){
case 10: if (_mode == 0) return "Logout"; else return "Logout";
case 9: if (_mode == 0) return "Login"; else return "Login";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}