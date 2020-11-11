package com.github.artiombond.classestask;

import  java.time.LocalTime;

public class Train {
    private String destination;
    private int number;
    private LocalTime departureTime;
    private int commonSeats;
    private int coupeSeats;
    private int reservedSeat;
    private int luxSeats;

    public Train(String destination, int number, LocalTime departureTime, int commonSeats, int coupeSeats, int reservedSeat, int luxSeats) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.commonSeats = commonSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeat = reservedSeat;
        this.luxSeats = luxSeats;
    }

    public Train(String destination, int number, LocalTime departureTime, int commonSeats, int coupeSeats) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.commonSeats = commonSeats;
        this.coupeSeats = coupeSeats;
    }

    public Train(String destination, int number, LocalTime departureTime, int luxSeats) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.luxSeats = luxSeats;
    }


    public String getDestination() {
        return destination;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getCommonSeats() {
        return commonSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }

    public int getLuxSeats() {
        return luxSeats;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setCommonSeats(int commonSeats) {
        this.commonSeats = commonSeats;
    }

    public void setCoupeSeats(int coupeSeats) {
        this.coupeSeats = coupeSeats;
    }

    public void setReservedSeat(int reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public void setLuxSeats(int luxSeats) {
        this.luxSeats = luxSeats;
    }

    @Override
    public String toString() {
        return "Поезд номер: " + number +
                " Пункт назначения: " + destination +
                ", Время отправления: " + departureTime +
                ", Общие места: " + commonSeats +
                ", Купе: " + coupeSeats +
                ", Плацкарт: " + reservedSeat +
                ", Люкс: " + luxSeats + "\n";
    }
}

