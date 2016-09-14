package def;


public class PolishNotationStack extends StackLinked<Double> {
	private int maximumStackSize;
	
	public PolishNotationStack() {
		super();
		this.maximumStackSize = super.size();
	}

	public void add() {
		super.push(super.pop().doubleValue()+super.pop().doubleValue());
	}
	
	public void sub() {
		super.push(super.pop().doubleValue()-super.pop().doubleValue());
	}
	
	public void mult() {
		super.push(super.pop().doubleValue()*super.pop().doubleValue());
	}
	
	public void div() {
		super.push(super.pop().doubleValue()/super.pop().doubleValue());
	}
	
	public void dup() {
		super.push(super.top().doubleValue());		
		this.refreshMaxStackSize();
	}
	
	public void swap() {
		double a = super.pop().doubleValue();
		double b = super.pop().doubleValue();
		super.push(a);
		super.push(b);
	}
	
	public void sin() {
		super.push(Math.sin(super.pop().doubleValue()));
	}
	
	public void cos() {
		super.push(Math.cos(super.pop().doubleValue()));
	}
	
	public void atan() {
		super.push(Math.atan2(super.pop().doubleValue(), super.pop().doubleValue()));
	}
	
	public void refreshMaxStackSize() {
		this.maximumStackSize = super.size() > this.maximumStackSize ? super.size() : this.maximumStackSize;
	}
	
	@Override
	public void push(Double element) {
		super.push(element);
		this.refreshMaxStackSize();
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf("SIZE: %4d  MAX SIZE: %4d\n\n", super.size(), this.maximumStackSize);
	}
}
