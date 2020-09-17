package com.tyy.ss.pojo;

/**
 * 实体类实现Serializable接口：将对象转变成一串由二进制字节组成的数组，
 * 可以通过将二进制数据保存到磁盘或者传输网络，磁盘或者网络接收者可以在对象的属类的模板上来反序列化类的对象，
 * 达到对象持久化的目的。
 */
public class User implements java.io.Serializable {
	public Integer user_id;
	public String user_name;
	public String user_password;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", getUser_id()=" + getUser_id() + ", getUser_name()=" + getUser_name() + ", getUser_password()="
				+ getUser_password() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
