# JPA-OneToMany-Example
JPA Hibernate OneToMany Simple Example on MySQL. Простой пример маппинга OneToMany c MySQL.
<h3>1. Create tables on MySQL Serlver/Создадим таблицы в базе данных</h3>

<pre>
CREATE TABLE `Cart` (
  `cart_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `total` decimal(10,0) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
</pre>

<pre>
CREATE TABLE `Items` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) unsigned NOT NULL,
  `item_id` varchar(10) NOT NULL,
  `item_total` decimal(10,0) NOT NULL,
  `quantity` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_id` (`cart_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `Cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
</pre>

<h3>2. Create Maven Project and add depensenses in pom.xml/Создаем проект под управлением Maven и добавляем зависмости</h3>
<pre>
We will need these dependencies:
 - hibernate-core       v.5.2.9.Final
 - hibernate-validator  v.5.4.1.Final
 - mysql-connector-java v.5.1.4
 
!!!You need to be careful with the versions. Some are not compatible/Нужно быть внимательным с версиями. Некоторые не совместимы 
</pre>
