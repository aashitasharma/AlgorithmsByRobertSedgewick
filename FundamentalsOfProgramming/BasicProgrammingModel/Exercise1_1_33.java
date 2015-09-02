public class Exercise1_1_33{
    public static double dot(double[] x, double[] y){
        if (x.length != y.length) 
            throw new RuntimeException("Illegal vector dimensions.");
        double sum = 0.0;
        for (int i = 0; i < x.length; i++)
            sum += x[i] * y[i];
        return sum;
    }
    
    public static double[][] mult(double[][] A, double[][] B){        
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) 
            throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++)
            for (int j = 0; j < nB; j++)
                for (int k = 0; k < nA; k++)
                    C[i][j] += (A[i][k] * B[k][j]);
        return C;
    }
    
    public static double[][] transpose(double[][] A){
         int m = A.length;
        int n = A[0].length;
        double[][] C = new double[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[j][i] = A[i][j];
        return C;
    }
    
    public static double[] mult(double[][] A, double[] x){
        int m = A.length;
        int n = A[0].length;
        if (x.length != n) 
            throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += (A[i][j] * x[j]);
        return y;
    }
    
    public static double[] mult(double[] x, double[][] A){
        int m = A.length;
        int n = A[0].length;
        if (x.length != m) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                y[j] += (A[i][j] * x[i]);
        return y;
    }
    
    public static void main(String[] args){
        double[] x = {1.0, 2.0, 3.0, 4.0 };
        double[] y = {5.0, 2.0, 4.0, 1.0 };
        double[][] a = {{0.0, 1.0, 2.0, 3.0},
            {3.0, 2.0, 1.0, 0.0},
            {3.0, 5.0, 6.0, 1.0},
            {3.0, 8.0, 3.0, 4.0}};
        double[][] b = {{0.0, 1.0, 2.0, 3.0},
            {3.0, 2.0, 1.0, 0.0},
            {3.0, 5.0, 6.0, 1.0},
            {3.0, 8.0, 3.0, 4.0}};
        
        System.out.println("Dot Result of X and Y is " + dot(x, y));
        System.out.println("**************************************");
        
        double[][] multResult = mult(a, b);
        System.out.println("Matrix Multiplication of A and B");
        for(int i = 0; i < multResult.length; i++){
            for(int j = 0; j < multResult[0].length; j++)
            System.out.printf("%5.1f ",multResult[i][j]);
            System.out.println();
        }
        System.out.println("**************************************");
        
        double[][] transposeResult = transpose(a);
        System.out.println("Transpose of A ");
        for(int i = 0; i < transposeResult.length; i++){
            for(int j = 0; j < transposeResult[0].length; j++)
            System.out.printf("%5.1f ",transposeResult[i][j]);
            System.out.println();
        }
        System.out.println("**************************************");
        
        double[] matrixVectorResult = mult(a, x);
        System.out.println("Matrix-Vector Product of A and X");
        for(int i = 0; i < matrixVectorResult.length; i++)
            System.out.print(matrixVectorResult[i] + " ");
        System.out.println();
        System.out.println("**************************************");
        
        double[] vectorMatrixResult = mult(y, a);
        System.out.println("Vector-Matrix Product of X and A");
        for(int i = 0; i < vectorMatrixResult.length; i++)
            System.out.print(vectorMatrixResult[i] + " ");
        System.out.println();
        System.out.println("**************************************");
    }
    
}