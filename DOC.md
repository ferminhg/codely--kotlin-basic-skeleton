## Scope Functions

Las scope functions se diferencian de dos formas:

- Por lo que devuelven
- Por el uso del input que reciben

Vamos a verlas una por una

### Let

¿Qué devuelve? El resultado de ejecutar el código definido dentro

¿Cómo se usa el input? Mediante it

¿Cuándo es útil? En muchas ocasiones pero especialmente cuando tenemos un código que solo debemos ejecutar si un valor nullable no es null

```kotlin
fun greetingWithName(name: String?) {
    name?.let { //solo entra en el bloque si name no es null
        println("Hello $it") //dentro del bloque usamos it
    }
}
```

### With

¿Qué devuelve? El resultado de ejecutar el código definido dentro

¿Cómo se usa el input? Mediante this, es importante mencionar que esta función recibe el objeto como un argumento

¿Cúando es útil? Cuando queremos llevar a cabo varias acciones utilizando un mismo objeto


```kotlin
fun example(name: String) {
    val firstLetterLowercase = with(name) {
        //dentro del bloque usamos this, podría omitirse
        println("Name in uppercase ${this.uppercase()}")
        this.trim().lowercase()
    } //aquí tenemos el valor de name en lowercase
    .first()
    
    println("First letter in lowercase $firstLetterLowercase")
}
```

### Run

¿Qué devuelve? El resultado de ejecutar el código definido dentro

¿Cómo se usa el input? Mediante this

Se parece a with pero la forma de utilizarla es igual que la del let aunque también se puede usar sin input

¿Cúando es útil? Mismos casos que el with pero queremos usarlo como una extension function o si no tenemos input

```kotlin
fun example() {
    val randomInt = run {
        println("Run block without input")
        Random.nextInt()
    } // aquí tenemos un int aleatorio
    val sum = randomInt.run {
        //dentro del bloque podemos usar this
        println("Run block with input $this")
        this+1
    } //aquí tenemos la suma del int aleatorio +1
    println("$randomInt + 1 = $sum")
}
```


### Apply

¿Qué devuelve? El objeto que llama al apply

¿Cómo se usa el input? Usando this aunque puede omitirse

¿Cúando es útil? Cuando modificamos de alguna forma el objeto que llama al apply pero no devolvemos ningún valor


```kotlin
data class NameAndModifications(
    val value: String,
    var valueLowercase: String? = null,
    var valueUpperCase: String? = null
)
fun example(name: String) {
    val value = NameAndModifications(name).apply {
        //dentro del bloque podemos usar this u omitirlo
        this.valueLowercase = this.value.lowercase()
        this.valueUpperCase = this.value.uppercase()
    } // aquí tenemos NameAndModifications con todos los valores configurados
    println(value)
}
```


### Also

¿Qué devuelve? El objeto que llama al also

¿Cómo se usa el input? Con it

¿Cúando es útil? Cuando necesitamos el objeto pero no sus atributos directamente, muy útil para loggear


```kotlin
fun example() {
    Random.nextInt().also {
        //it representa el int aleatorio que acabamos de generar
        println("El numero aleatorio generado es: $it")
    } //aquí seguimos teniendo el int aleatorio********
}
```