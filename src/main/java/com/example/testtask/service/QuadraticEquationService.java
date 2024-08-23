package com.example.testtask.service;

import org.springframework.stereotype.Service;

@Service
public class QuadraticEquationService {
    public double calculateX(double a, double b, double c, boolean round) {
        double discriminant = calculateDiscriminant(a, b, c);
        double x = (b + Math.sqrt(discriminant)) / (2 * a);

        return round ? Math.round(x * 10.0) / 10.0 : x;
    }

    public double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
}