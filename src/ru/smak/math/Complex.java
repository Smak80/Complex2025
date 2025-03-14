package ru.smak.math;

import org.jetbrains.annotations.NotNull;

public class Complex {
    private double re;
    private double im;

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public Complex(){
        re = im = 0.0;
    }

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        if (re != 0.0 || im == 0.0) sb.append(re);
        if (im != 0.0){
            sb.append(im > 0 ? " + " : " - ");
            sb.append(Math.abs(im));
            sb.append("i");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object other){
        if (other.getClass().isInstance(Complex.class)){
            var oc = (Complex)other;
            return oc.re == re && oc.im == im;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        var result = Double.valueOf(re).hashCode();
        result = 31 * result + Double.valueOf(im).hashCode();
        return result;
    }

    public Complex plus(@NotNull Complex other){
        return new Complex(re + other.re, im + other.im);
    }

    public Complex minus(@NotNull Complex other){
        return new Complex(re - other.re, im - other.im);
    }

    public Complex times(@NotNull Complex other){
        return new Complex(
            re * other.re - im * other.im,
            re * other.im + im * other.re
        );
    }

    public Complex div(@NotNull Complex other){
        var den = other.re * other.re + other.im * other.im;
        return new Complex(
            (re * other.re + im * other.im) / den,
            (im * other.re - re * other.im) / den
        );
    }

    public Complex conjugate(){
        return new Complex(re, -im);
    }

    public void timesAssign(@NotNull Complex other){
        double newRe = re * other.re - im * other.im;
        im = re * other.im + im * other.re;
        re = newRe;
    }

}
