# Pasos para Crear una Arquitectura REST con Spring Boot en Java

1. **Crear el Modelo de Datos:**
   - Define las entidades JPA que representan los datos de la aplicación.
   - Utiliza anotaciones como `@Entity`, `@Id`, `@Table`,`@Temporal`,`@GeneratedValue`,`@OneToOne`,`@OneToMany`,`@ManyToMany`, etc.
   - Dependencia Lombok , Uso de `@Data` para el uso de getters, setters, toString, Equals , Hash Code.
   - Para el contructor vacio  `@NoArgsConstructor` y lleno `@AllArgsConstructor`.
   - Relacionando tablas de * - 1.
   ```java
      @Entity
      @Data
      @NoArgsConstructor
      @AllArgsConstructor
      public class Producto {
          @Id
          @GeneratedValue (strategy = GenerationType.IDENTITY)
          private Integer idProducto;

          @Column(nullable = true , length = 30)
          private String nombre;

          @Column(nullable = true , length = 60)
          private String descripcion;
          @Column(nullable = true)
          private Float precio;

          @Column(nullable = true )
          private Integer cantidadStock;

          //adds fk
          @ManyToOne
          @JoinColumn(name = "id_proveedor" , nullable = false,
          foreignKey = @ForeignKey (name = "FkProductoProveedor"))
          private Proveedor proveedor;

          @ManyToOne
          @JoinColumn(name = "id_categoria" , nullable = false,
                  foreignKey = @ForeignKey (name = "FkProductoCategoria"))
          private Categoria categoria;
      }
   
    ```
   

2. **Crear el Repositorio:**
   - Define un repositorio JPA para manejar la interacción con la base de datos.
   - Crea una interfaz que extienda `JpaRepository` proporcionada por Spring Data JPA.
   
   ``` java
     @NoRepositoryBean             //Modelo,Integer
     public interface IGenericRepo <T,ID> extends JpaRepository<T,ID> {
     }
   ```

3. **Crear el Servicio:**
   - Define un servicio que contenga la lógica de negocio de la aplicación.
   - Maneja la interacción entre el controlador y el repositorio.
   - Declarar las funciones que va a realizar en la tabla

   ``` java
     //TABLA GENERICA SERVICE
     public interface IGenericService <T,ID>{
       T registrar(T t) throws Exception;
       T modificar (T t) throws Exception;
       List<T> listar() throws Exception;
       T listarPorId(ID id) throws  Exception;
       void eliminar(ID id) throws Exception;
     }
   ```
   - Consumir desde las interfaces propias
   ``` java
     public interface ICategoriaService extends IGenericService<Categoria,Integer>{
     }
   ```
4. **Implementacion del Servicio:**
   - Consumir repository JPA
   - Implementar las funciones de Service Generico
   - Implmentar metodos/componentes de funcion GenericService
   ``` java
     public abstract class IGenericServiceImpl <T,ID> implements IGenericService<T,ID> {

     //Traer Datos Iniciales de JPA , Repository Generico.
     protected abstract JpaRepository <T,ID>getRepo();

     //traer los componentes creados en IGenericService

     //Metodo de Registrar
     @Override
     public T registrar (T t) throws  Exception{
         return getRepo().save(t);
     }

     //Metodo de Modificar
     @Override
     public T modificar (T t) throws  Exception{
         return getRepo().save(t);
     }

     //Metodo de Listar
     @Override
     public List<T> listar() throws Exception{
         return getRepo().findAll();
     }

     //Metodo de Listar por Id
     @Override
     public T listarPorId(ID id) throws  Exception{
         return getRepo().findById(id).orElse(null);
     }

     //Eliminar
     @Override
     public void eliminar(ID id) throws Exception{
         getRepo().deleteById(id);
     }
     }
   ```
   - Consumir desde el Generico desde la clase
   - Heredar el Generico de Implementacion `extends`
   - Implementar el Servicio Propio `implements`
   - Anotacion de la clase Implementada `@Service`
   ``` java
     @Service
     public class CategoriaServiceImpl extends  IGenericServiceImpl <Categoria,Integer> implements ICategoriaService {
          //Instanciar Repository
          @Autowired
          private ICategoriaRepo categoriaRepo;

          //Metodo implementado
          @Override
          protected JpaRepository<Categoria, Integer> getRepo() {
          return categoriaRepo;
          }
      }
    ```


5. **Crear el Controlador:**
   - Define un controlador REST que maneje las solicitudes HTTP y llame a los métodos del servicio correspondientes.
   - Anotaciones `@RestController`,`@RequestMaping("")`,`@Get,@Post,@Delete,@Put`
   - Uso de Modelo Principal
   - Nivel de madurez 1
   ```java
      @RestController
      @RequestMapping("/categoria")
      public class CategoriaController {

       //Service
       @Autowired
       private ICategoriaService service;

       //ModeloMapper

       // RICH NIVEL 1 / MODELO

       // LISTAR
       @GetMapping("/1")
       public ResponseEntity<List<Categoria>> listar1() throws Exception {
           List<Categoria> lista = service.listar();
           return new ResponseEntity<>(lista, HttpStatus.OK);
       }

       // LISTARPORID
       @GetMapping("/1/{id}")
       public ResponseEntity<Categoria> listarporIdD(@PathVariable("id") Integer id) throws Exception {
           Categoria obj = service.listarPorId(id);
           return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
       }

       // REGISTRAR
       @PostMapping("/1")
       public ResponseEntity<Categoria> registrarr(@RequestBody Categoria cat) throws Exception {
           Categoria obj = service.registrar(cat);
           return new ResponseEntity<Categoria>(obj, HttpStatus.CREATED);
       }

       // MODIFICAR
       @PutMapping("/1")
       public ResponseEntity<Categoria> modificarr(@RequestBody Categoria cat) throws Exception {
           Categoria obj = service.modificar(cat);
           return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
       }

       // ELIMINAR
       @DeleteMapping("/1/{id}")
       public ResponseEntity<Void> eliminarr(@PathVariable("id") Integer id) throws Exception {
           service.eliminar(id);
           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
       }

   }
   
   ```
   

6. **Configurar la Aplicación Spring Boot:**
   - Asegúrate de tener las anotaciones adecuadas en tu clase principal de la aplicación.
   
7. **Configurar la Base de Datos:**
   - Define la conexión a la base de datos en `application.properties` o `application.yml`.
   - DB mysql dependeciaMysql
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/backendflorista?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=main
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.show-sql=false
   spring.jpa.hibernate.ddl-auto=update
   ```

8. **Ejecutar la Aplicación:**
   - Ejecuta tu aplicación Spring Boot y prueba los endpoints REST utilizando herramientas como Postman o CURL.
   ```http
   #Localhost + @RequestMaping + @MetodMapping
   http://localhost:8080/categoria/1
   ```
