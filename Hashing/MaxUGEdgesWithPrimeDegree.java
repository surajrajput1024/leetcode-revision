package Hashing;

import java.util.Scanner;

public class MaxUGEdgesWithPrimeDegree {

    // Check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Use Sieve of Eratosthenes to find the nearest prime less than n
    public static int checkNearestPrime(int n) {
        if (n <= 2) return -1; // No primes less than 2

        // Sieve of Eratosthenes
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;
        
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Find the largest prime less than n
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime[i]) return i;
        }

        return -1;
    }

    public int maxEdges(int n) {
        // No edges possible for n <= 2
        if (n <= 2) return 0; 
    
        int maxEdges = 0;
    
        // Case 1: If n - 1 is prime
        if (isPrime(n - 1)) {
            long sumOfDegrees = (long) n * (n - 1);
            // Number of edges is sum of degrees / 2
            maxEdges = (int) (sumOfDegrees / 2);  
        } 

        
        // Case 2: Find the nearest prime less than n and use it as the degree
        else {
            int nearestPrime = checkNearestPrime(n);
    
            // Calculate sum of degrees based on nearestPrime
            long sumOfDegrees = (long) n * nearestPrime;
    
            // If the sum of degrees is odd, adjust by setting one node’s degree to 2
            if (sumOfDegrees % 2 != 0) {
                sumOfDegrees = (long) (n - 1) * nearestPrime + 2;
            }
    
            maxEdges = (int) (sumOfDegrees / 2);
        }
    
        return maxEdges;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of nodes (N): ");
        int n = s.nextInt();
        
        MaxUGEdgesWithPrimeDegree maxUGEdgesWithPrimeDegree = new MaxUGEdgesWithPrimeDegree();
        int maxEdges = maxUGEdgesWithPrimeDegree.maxEdges(n);

        System.out.println("Maximum edges with " + n + " nodes is: " + maxEdges);
        s.close();
    }
}
