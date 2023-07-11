# 🎯 N+1 Problem Nedir?

* N+1 problemi, bir entity ile ilişkili olan diğer entity'leri yüklerken Hibernate'in karşılaştığı bir performans
  problemidir.

* Bu problem, bir ana entity ile ilişkili birden fazla alt entity'yi yüklerken ortaya çıkar.

* Hibernate, varsayılan olarak her bir alt entity için ayrı bir SQL sorgusu çalıştırır.

* Bu da, veritabanına gereksiz yere çok sayıda sorgu gönderilmesine ve dolayısıyla uygulamanın performansının düşmesine
  sebep olur.

# 🎯 N+1 Problem Nasıl Çözülür?

* Bu problem, Hibernate'in "Join Fetch" veya "Entity Graph" gibi özelliklerini kullanarak çözülebilir.

* Bu özellikler, bir ana entity ile ilişkili alt entity'leri tek bir SQL sorgusu ile yüklemeyi sağlar.

* Veritabanımızda author ve book adında iki tablo olduğunu düşünelim.

* "author" tablosunda her bir yazarın bilgileri (id, birth_date, first_name, last_name) bulunurken, "book" tablosunda
  her
  bir kitabın bilgileri (id, title, author_id) bulunuyor.

* "book" tablosundaki author_id, book'un hangi author'a ait olduğunu gösterir ve bu author tablosundaki id ile
  ilişkilidir.


* Author Tablosu

| id | birth_date | first_name | last_name |
|----|------------|------------|-----------|
| 1  | 1970-01-01 | 	Ahmet     | Yılmaz    |
| 2  | 1980-02-02 | Mehmet     | Öz        |
| 3  | 1990-03-03 | Ayşe       | Kara      |

* Book Tablosu

| id | title   | author_id | 
|----|---------|-----------|
| 1  | Kitap 1 | 1         |
| 2  | Kitap 2 | 1         |
| 3  | Kitap 3 | 2         |
| 4  | Kitap 4 | 2         |
| 5  | Kitap 5 | 3         |

* Şimdi, "SELECT a FROM Author a JOIN FETCH a.books" sorgusunun ne yaptığına bakalım.

* Bu sorgu, author tablosundaki her bir satırı (Author entity'sini) ve her bir Author'a ait olan book tablolarındaki
  satırları (yani Book entity'lerini) bir arada getirir.

* Bunun sonucunda, her bir Author'un tüm Book'larına tek bir SQL sorgusuyla erişilmiş olur.

* Yani, bu sorgu sonucunda, Author ve ona ait olan Book'ların bir listesi elde edilir:

* Ahmet Yılmaz: Kitap 1, Kitap 2
* Mehmet Öz: Kitap 3, Kitap 4
* Ayşe Kara: Kitap 5

* Bu sayede, her bir Author için Book'ları getirmek adına ekstra SQL sorgusu yapılmasına gerek kalmaz ve N+1 problemi
  çözülmüş olur.

* Join Fetch ile Çözüm :

 ```java

@Query("SELECT a FROM Author a JOIN FETCH a.books")
  List<Author> findAllWithBooks();

```

* Bu sorguda, JOIN FETCH a.books ifadesi ile her Author için ilişkili Book'lar birleştirilerek getirilir.

* Böylece, her Author için Book'ları getirmek adına ekstra SQL sorgusu çalıştırmaya gerek kalmaz.

## 📌 Kullanılmadan Önce

* Her Author için ilişkili Book'ları getirmek için ayrı bir SQL sorgusu çalıştırılır:

 ```sqlite

select a1_0.id,
       a1_0.birth_date,
       a1_0.first_name,
       a1_0.last_name
from author a1_0


```

* Her Author için Book'ları yüklemek için ek sorgular yapılır:

 ```sqlite

select b1_0.author_id,
       b1_0.id,
       b1_0.title
from book b1_0
where b1_0.author_id = ?

```

## 📌 Kullanıldıktan Sonra

* Author'lar ve ilişkili Book'lar tek bir SQL sorgusu ile yüklenir:

 ```sqlite

select a1_0.id,
       a1_0.birth_date,
       b1_0.author_id,
       b1_0.id,
       b1_0.title,
       a1_0.first_name,
       a1_0.last_name
from author a1_0
         join
     book b1_0
     on a1_0.id = b1_0.author_id

```

* Her bir Author ve onun ilişkili Book'larına tek bir SQL sorgusu ile ulaşılır ve bu da N+1 problemini çözer.

# 🎯 Proje Çalışma Adımları ?

## 📌 docker-compose.yaml

```yaml
docker-compose -f docker-compose-test.yaml up -d
```

```yaml
docker-compose -f docker-compose-test.yaml down -v
```

## 📌 hibernate-service

▶️ swagger = localhost:8088/rasitesdmr

<p align ="center">
<img src = "https://github.com/rasitesdmr/SpringBoot-Hibernate-NPlusOne-Problem/blob/master/images/hb-1.png">
</p>