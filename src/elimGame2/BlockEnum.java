package elimGame2;

public enum BlockEnum {	
	RED(1,"��"), GREEN(2,"��"), WHITE(3,"��"), YELLOW(4,"��") ,PURPLE(5,"��"),BLUE(6,"��"),ELIM(0,"���");
	
	public int _value;
	public final String colour;
	private BlockEnum(int value,String s){
		this._value=value;
		colour=s;
	}
	
	public int value(){
		return this._value;
	}
	public String colour(){
		return colour;
	}
	
	
	
}

