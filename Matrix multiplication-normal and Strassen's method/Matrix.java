public class Matrix 
{
	private int [][] matrix;
	
	public Matrix(int [][] mx)
	{
		int row = mx.length;
		int col = mx[0].length;
		if(isPowerOf2(row) && isPowerOf2(col))
		{
				matrix = new int [row][col];
				for(int i = 0; i<row; i++)
				{
					for(int j = 0; j<col; j++)
					{
						matrix[i][j] = mx[i][j];
					}
				}
		}
		else
			System.out.println("The size of 2d array must be power of 2!");
		
	}
	
	public Matrix productRegular(Matrix m2)
	{
			int [][] product = new int [this.getSize()][this.getSize()];
			for(int i = 0;i<this.getSize();i++)
			{
				for(int j = 0; j < this.getSize();j++)
				{
					int sum = 0;
					for(int k = 0;k<this.getSize();k++)
					{
						sum += matrix[i][k] * m2.getMatrix()[k][j];
					}
					product[i][j] = sum;
				}
			}
			return new Matrix(product);		
	}
	
	public Matrix productStrassen(Matrix m2)
	{
		if(this.getSize() == 1)
		{
			return this.productRegular(m2);
		}
		else
		{
			Matrix a11 = copySubMatrix(this,0,0,this.getSize()/2);
			Matrix a12 = copySubMatrix(this,0,this.getSize()/2,this.getSize()/2);
			Matrix a21 = copySubMatrix(this,this.getSize()/2,0,this.getSize()/2);
			Matrix a22 = copySubMatrix(this,this.getSize()/2,this.getSize()/2,this.getSize()/2);
			
			Matrix b11 = copySubMatrix(m2,0,0,m2.getSize()/2);
			Matrix b12 = copySubMatrix(m2,0,m2.getSize()/2,m2.getSize()/2);
			Matrix b21 = copySubMatrix(m2,m2.getSize()/2,0,m2.getSize()/2);
			Matrix b22 = copySubMatrix(m2,m2.getSize()/2,m2.getSize()/2,m2.getSize()/2);
			

			Matrix M1 = matrixAddition(a11, a22).productStrassen(matrixAddition(b11, b22));
			Matrix M2 = matrixAddition(a21,a22).productStrassen(b11);
			Matrix M3 = a11.productStrassen(matrixSubtraction(b12, b22));
			Matrix M4 = a22.productStrassen(matrixSubtraction(b21,b11));
			Matrix M5 = matrixAddition(a11,a12).productStrassen(b22);
			Matrix M6 = matrixSubtraction(a21,a11).productStrassen(matrixAddition(b11,b12));
			Matrix M7 = matrixSubtraction(a12,a22).productStrassen(matrixAddition(b21,b22));
			
			Matrix c11 = matrixAddition(matrixSubtraction(matrixAddition(M1,M4),M5),M7);
			Matrix c12 = matrixAddition(M3,M5);
			Matrix c21 = matrixAddition(M2,M4);
			Matrix c22 = matrixAddition(matrixAddition(matrixSubtraction(M1,M2),M3),M6);
            return mergeMatrix(c11,c12,c21,c22);		
		}
	}
	
	public static boolean isPowerOf2(final int n) 
	{
		if (n <= 0) 
		{
	        return false;
	    }
		else
			return (n & (n - 1)) == 0;
	}
	
	public int[][] getMatrix()
	{
		return matrix;
	}
	public int getSize()
	{
		return matrix.length;
	}
	public void printMatrix()
	{
		for(int i = 0; i<this.getSize();i++)
		{
			for(int j = 0; j<this.getSize();j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	public static Matrix copySubMatrix(Matrix m, int rowIndex,int colIndex, int size)
	{
		if(rowIndex + size <= m.getSize() && colIndex+size <= m.getSize())
		{
			int [][] temp = new int [size][size];
			for(int i = rowIndex;i<rowIndex + size;i++)
			{
				for(int j = colIndex;j<colIndex+size;j++)
				{
					temp[i-rowIndex][j-colIndex] = m.getMatrix()[i][j];
				}
			}
			return new Matrix(temp);
		}
		else
		{
			System.out.println("Out of bound Error! return the original Matrix");
			return m;
		}
	}
	public static Matrix matrixAddition(Matrix m1, Matrix m2)
	{
		int [][] sum = new int [m1.getSize()][m1.getSize()];
		for(int i = 0;i<m1.getSize();i++)
		{
			for(int j = 0;j<m1.getSize();j++)
			{
				sum[i][j] = m1.getMatrix()[i][j]+m2.getMatrix()[i][j];
			}
		}
		return new Matrix(sum);
	}
	
	public static Matrix matrixSubtraction(Matrix m1, Matrix m2)
	{
		int [][] difference = new int [m1.getSize()][m1.getSize()];
		for(int i = 0;i<m1.getSize();i++)
		{
			for(int j = 0;j<m1.getSize();j++)
			{
				difference[i][j] = m1.getMatrix()[i][j]-m2.getMatrix()[i][j];
			}
		}
		return new Matrix(difference);
	}
	
	public static Matrix mergeMatrix(Matrix m1,Matrix m2,Matrix m3,Matrix m4)
	{
		int [][] temp = new int [m1.getSize()*2][m1.getSize()*2];
		
		for(int i = 0;i<m1.getSize();i++)    // upper-left copy m1
		{
			for(int j = 0;j<m1.getSize();j++)
			{
				temp[i][j] = m1.getMatrix()[i][j];
			}
			
		}
		
		for(int i = 0;i<m2.getSize();i++)  //upper-right copy m2
		{
			for(int j = m2.getSize();j < temp.length;j++)
			{
				temp[i][j] = m2.getMatrix()[i][j-m2.getSize()];
			}
		}
		
		for(int i = m3.getSize();i<temp.length;i++)  //lower-left copy m3
		{
			for(int j = 0;j < m3.getSize();j++)
			{
				temp[i][j] = m3.getMatrix()[i-m3.getSize()][j];
			}
		}
		
		for(int i = m4.getSize();i<temp.length;i++)  //lower-right copy m4
		{
			for(int j = m4.getSize();j < temp.length;j++)
			{
				temp[i][j] = m4.getMatrix()[i-m4.getSize()][j-m4.getSize()];
			}
		}
		
		return new Matrix(temp);
	}

}
