package clases;

public class Usuario {
		String nombre="";
		String cuenta="";
		String clave="";
		public Usuario(String nombre, String cuenta, String clave) {
			super();
			this.nombre = nombre;
			this.cuenta = cuenta;
			this.clave = clave;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCuenta() {
			return cuenta;
		}
		public void setCuenta(String cuenta) {
			this.cuenta = cuenta;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}

}
