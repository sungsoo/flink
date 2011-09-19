package eu.stratosphere.sopremo.jsondatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import eu.stratosphere.pact.common.type.base.PactInteger;

public class IntNode extends NumericNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4250062919293345310L;

	protected final PactInteger value;

	public IntNode() {
		this.value = new PactInteger();
	}

	public IntNode(final int v) {
		this.value = new PactInteger(v);
	}

	public static IntNode valueOf(final int v) {
		return new IntNode(v);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.value.hashCode();
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		final IntNode other = (IntNode) obj;
		if (!this.value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public int getTypePos() {
		return TYPES.IntNode.ordinal();
	}

	@Override
	public void read(final DataInput in) throws IOException {
		this.value.read(in);
	}

	@Override
	public void write(final DataOutput out) throws IOException {
		this.value.write(out);
	}

	@Override
	public Integer getIntValue() {
		return this.value.getValue();
	}

	@Override
	public Long getLongValue() {
		return Long.valueOf(this.value.getValue());
	}

	@Override
	public BigInteger getBigIntegerValue() {
		return BigInteger.valueOf(this.value.getValue());
	}

	@Override
	public BigDecimal getDecimalValue() {
		return BigDecimal.valueOf(this.value.getValue());
	}

	@Override
	public Double getDoubleValue() {
		return Double.valueOf(this.value.getValue());
	}

	@Override
	public boolean isIntegralNumber() {
		return true;
	}

	public String getValueAsText() {
		return this.value.toString();
	}
	@Override
	public TYPES getType() {
		return TYPES.DoubleNode;
	}
	
}
