public class Vec2
{

	private double x;
	private double y;

	public Vec2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public static Vec2 zero()
	{
		return new Vec2(0, 0);
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double setX(int x)
	{
		this.x = x;
		return x;
	}

	public double setY(int y)
	{
		this.y = y;
		return y;
	}

	public void set(Vec2 v)
	{
		this.x = v.x;
		this.y = v.y;
	}

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vec2 add(double x, double y)
	{
		return new Vec2(this.x + x, this.y + y);
	}

	public Vec2 addLocal(double x, double y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vec2 add(Vec2 v)
	{
		return add(v.x, v.y);
	}

	public Vec2 addLocal(Vec2 v)
	{
		this.x += v.x;
		this.y += v.y;
		return this;
	}

	public Vec2 sub(double x, double y)
	{
		return new Vec2(this.x + x, this.y + y);
	}

	public Vec2 subLocal(double x, double y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vec2 sub(Vec2 v)
	{
		return add(v.x, v.y);
	}

	public Vec2 subLocal(Vec2 v)
	{
		this.x -= v.x;
		this.y -= v.y;
		return this;
	}

	public Vec2 scale(double s)
	{
		return new Vec2(x * s, y * s);
	}

	public Vec2 scaleLocal(double s)
	{
		this.x *= s;
		this.y *= s;
		return this;
	}

	public double dot(Vec2 v)
	{
		return x * v.x + y * v.y;
	}

	// Magnitude
	public double length()
	{
		return Math.sqrt(x * x + y * y);
	}

	public double norm()
	{
		return Math.sqrt(x * x + y * y);
	}

	public Vec2 normalize()
	{
		double length = length();
		return new Vec2(x / length, y / length);
	}

	public Vec2 normalizeLocal()
	{
		double length = length();
		this.x /= length;
		this.y /= length;
		return this;
	}

	@Override
	public int hashCode()
	{
		long bits = 7L;
		bits = 31L * bits + Double.doubleToLongBits(x);
		bits = 31L * bits + Double.doubleToLongBits(y);
		return (int) (bits ^ (bits >> 32));
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
		{
			return true;
		}
		if (obj instanceof Vec2)
		{
			Vec2 v = (Vec2) obj;
			return (x == v.x) && (y == v.y);
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "Vec2 <" + x + ", " + y + ">";
	}

}
