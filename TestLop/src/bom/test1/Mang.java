package bom.test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mang {

	static int n;
	static int[] array;

	public int Doc_So() throws IOException {
		InputStreamReader gt = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(gt);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	public void Tong() {
		int tong = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] > 0 && array[i] % 2 == 0) {
				tong += array[i];
			}
		}
		System.out.println("Tong cac phan tu duong chan: " + tong);
	}

	public void Tim(int k) {
		boolean kiemtra = false;
		for (int i = 0; i < n; i++) {
			if (array[i] == k) {
				System.out.println("So " + k + " o vi tri " + i);
				kiemtra = true;
				break;
			}
		}
		if (!kiemtra)
			System.out.println("Tim khong thay!");
	}

	// sap xep
	public void Sapxep() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (array[i] > array[j]) {
					int tam = array[i];
					array[i] = array[j];
					array[j] = tam;
				}
			}
		}
		System.out.println("Mang sau khi sap xep ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + "   ");
		}
	}

	// chen giu vi tri
	public void Chen(int D) {
		for (int i = 0; i < n; i++) {
			if (D < array[i]) {
				for (int j = n; j > i; j--) {
					array[j] = array[j - 1];
				}
				array[i] = D;
				break;
			}
		}
		System.out.println("Mang sau khi chen");
		for (int i = 0; i < n + 1; i++) {
			System.out.print(array[i] + "   ");
		}
	}

	public static void main(String[] args) {
		int k = 0, D = 0;
		Mang dt = new Mang();
		System.out.print("Nhap so luong phan tu: ");
		try {
			n = dt.Doc_So();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		array = new int[20];
		System.out.println("Nhap mang: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Phan tu thu " + i + " : ");
			try {
				array[i] = dt.Doc_So();
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
		}

		dt.Tong();
		System.out.print("Nhap so can kiem tra: ");
		try {
			k = dt.Doc_So();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		dt.Tim(k);
		dt.Sapxep();

		System.out.print("\nNhap so can chen: ");
		try {
			D = dt.Doc_So();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		dt.Chen(D);
	}

}
