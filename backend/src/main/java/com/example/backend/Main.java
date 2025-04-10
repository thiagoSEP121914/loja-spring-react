package com.example.backend;

import com.example.backend.entity.Estado;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Estado estado = new Estado(1L, "Sao paulo", "SP", new Date(), new Date());

        System.out.println(estado.getNome());
    }
}
