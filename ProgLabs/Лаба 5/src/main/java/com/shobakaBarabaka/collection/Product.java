package com.shobakaBarabaka.collection;


import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;
import java.time.ZoneId;



/**
 * main collection of Product class
 *
 * @author ShobakaBarabaka
 */
public class Product implements Serializable, Comparable<Product>{
    /**
     * Product's id
     * Field can't be null
     * Value of the field must be positive
     * Value of the field must be unique
     * Value of the field must be generated automatically
     */
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * Product's name
     * Field can't be null
     * String can't be empty
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Product's coordinates
     * Field can't be null
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * Product's creation date
     * Field can't be null
     * Value of the field must be generated automatically
     */
    private final LocalDate creationDate = LocalDate.now(ZoneId.systemDefault());//Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * Product's price
     * Field can be null
     * Value of the field must be positive
     */
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    /**
     * Product's part number
     * Field can be null
     * Length of the string must be less than or equal to 91
     */
    private String partNumber; //Длина строки не должна быть больше 91, Поле может быть null
    /**
     * Product's manufacture cost
     */
    private int manufactureCost;
    /**
     * Product's unit of measure
     * Field can be null
     */
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    /**
     * Product's manufacturer
     * Field can be null
     */
    private Organization manufacturer; //Поле может быть null


    {
        try {
            id = IdGenerator.getInstance().generateId();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            id = -1;
        }
    }

    /**
     * gets {@link Product}'s id
     *
     * @return Product's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * gets {@link Product}'s name
     *
     * @return Product's name
     */
    public String getName() {
        return name;
    }

    /**
     * sets {@link Product}'s name
     * @throws IllegalArgumentException if given name doesn't follow restrictions
     * @param name Product's name
     */
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name can't be null");
        if (name.isEmpty()) throw new IllegalArgumentException("name can't be empty");
        this.name = name;
    }


    /**
     * gets {@link Product}'s coordinates
     *
     * @return Product's coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * sets {@link Product}'s coordinates
     * @throws IllegalArgumentException if given coordinates doesn't follow restrictions
     * @param coordinates Product's coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new IllegalArgumentException("coordinates can't be null");
        this.coordinates = coordinates;
    }


    /**
     * gets {@link Product}'s creation date
     *
     * @return Product's creation date
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * gets {@link Product}'s price
     *
     * @return Product's price
     */
    public Float getPrice() {
        return price;
    }


    /**
     * sets {@link Product}'s price
     * @throws IllegalArgumentException if given price doesn't follow restrictions
     * @param price Product's price
     */
    public void setPrice(Float price) {
        if (price <= 0) throw new IllegalArgumentException("price must be greater than 0");
        this.price = price;
    }


    /**
     * gets{@link Product}'s part number
     *
     * @return Product's part number
     */
    public String getPartNumber() {
        return partNumber;
    }


    /**
     * sets {@link Product}'s part number
     * @throws IllegalArgumentException if given part number doesn't follow restrictions
     * @param partNumber Product's part number
     */
    public void setPartNumber(String partNumber) {
        if (partNumber.length() > 91) throw new IllegalArgumentException("part number length must be lower than 91");
        this.partNumber = partNumber;
    }


    /**
     * gets {@link Product}'s manufacture cost
     *
     * @return Product's manufacture cost
     */
    public int getManufactureCost() {
        return manufactureCost;
    }

    /**
     * sets {@link Product}'s manufacture cost
     * @param manufactureCost Product's manufacture cost
     */
    public void setManufactureCost(int manufactureCost) {
        this.manufactureCost = manufactureCost;
    }


    /**
     * gets {@link Product}'s unit of measure
     * @return Product's unit of measure
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }


    /**
     * sets {@link Product}'s unit of measure
     * @param unitOfMeasure Product's unit of measure
     */
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }


    /**
     * gets {@link Product}'s manufacturer
     * @return Product's manufacturer
     */
    public Organization getManufacturer() {
        return manufacturer;
    }

    /**
     * sets {@link Product}'s manufacturer
     * @param manufacturer Product's manufacturer
     */
    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return manufactureCost == product.manufactureCost && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(coordinates, product.coordinates) && Objects.equals(creationDate, product.creationDate) && Objects.equals(price, product.price) && Objects.equals(partNumber, product.partNumber) && Objects.equals(unitOfMeasure, product.unitOfMeasure) && Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, partNumber, manufactureCost, unitOfMeasure, manufacturer);
    }


    /**
     * @return a string representation of the {@link Product} object
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", partNumber='" + partNumber + '\'' +
                ", manufactureCost=" + manufactureCost +
                ", unitOfMeasure=" + unitOfMeasure +
                ", manufacturer=" + manufacturer +
                '}';
    }

    /**
     * Compares this object with the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price / Math.pow(this.manufactureCost, 2), o.id / Math.pow(o.price, 2));
    }


}