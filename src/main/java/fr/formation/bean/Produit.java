package fr.formation.bean;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "Discr")
public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String img;
	private String info;
	
	//CONTRUCTOR
	public Produit() {
		
	}

	public Produit(String name, float price, int quantity, String img, String info) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.img = img;
		this.info = info;
	}
	
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
	
	//OTHERS
	@Override
	public String toString() {
		return "Produit [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", img=" + img
				+ ", info=" + info + "]";
	}
}
