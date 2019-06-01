-- Categorias
insert into Categorias (categoria_id,nombre) values (1,'Rostro');
insert into Categorias (categoria_id,nombre) values (2,'Capilar');
insert into Categorias (categoria_id,nombre) values (3,'Fijador');
insert into Categorias (categoria_id,nombre) values (4,'Tinturas');
-- Marcas
insert into Marcas (marca_id,nombre,descripcion) values (1,'Nivea','Es una empresa de productos cosméticos, fundada por los inventores de la primera crema hidratante de la historia.');
insert into Marcas (marca_id,nombre,descripcion) values (2,'Herbal Essences','Herbal Essences es una marca de productos para el cuidado y cuidado del cabello de Clairol.');
insert into Marcas (marca_id,nombre,descripcion) values (3,'Fructis','Fructis Garnier combina la Piroctona Olamina y el ácido salicílico de origen natural, para eliminar la caspa, y combatir los agentes responsables de su reaparición.');
insert into Marcas (marca_id,nombre,descripcion) values (4,'Pantene','Pantene es una marca registrada de productos para el cuidado del cabello dirigido a la mujer, producido por Procter & Gamble.');
insert into Marcas (marca_id,nombre,descripcion) values (5,'TRESemmé','TRESemmé es una marca multinacional estadounidense de productos para el cuidado del cabello fabricada por primera vez en 1947');
insert into Marcas (marca_id,nombre,descripcion) values (6,'L´Oréal','L´Oréal es una empresa francesa de cosméticos y belleza, creada en 1909 por el químico Eugène Schueller.');
insert into Marcas (marca_id,nombre,descripcion) values (7,'St. Ives','En St Ives, somos fanáticos de todo lo natural. Es por eso que nuestros productos están hechos con humectantes 100% naturales.');
insert into Marcas (marca_id,nombre,descripcion) values (8,'Garnier','Garnier es una marca de cosméticos para el mercado masivo de la compañía francesa de cosméticos L´Oréal.');
insert into Marcas (marca_id,nombre,descripcion) values (9,'Gillette','Gillette es una marca de la empresa Procter & Gamble. Su propietaria inicial fue la compañía The Gillette Company.');
-- Productos
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(2,'Shampoo Oil Repair','Su fórmula penetra profundamente actuando en las 3 capas de la fibra capilar.','2.jpg',3,2,20);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(3,'Shampoo Renew Repair Argan Oil Of Morocco','Shampoo elaborado con bio renew, una mezcla de antioxidantes esenciales, áloe vera y algas marinas.','3.jpg',2,2,15);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(1,'Shampoo Renew Smooth Golden Moringa Oil','Shampoo elaborado a partir de ingredientes inspirados en la naturaleza para conseguir un cabello suave y más manejable.','1.jpg',2,2,40);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(5,'Acondicionador para cabello graso','Este es un acondicionador con vitamina A, B3 y B6 que le da al cabello mayor brillo y frescura.','5.jpg',3,2,33);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(4,'Shampoo Pro-V Restauración','Los shampoos Pantene Pro-V han sido actualizados con nuevos sistemas de limpieza que brindan una sensación de limpieza duradera.','4.jpg',4,2,21);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(6,'Acondicionador Renew Hydrate Coconut Milk','Acondicionador que hidrata y acondiciona el cabello en profundidad para que sea más suave y resistente frente a futuros daños. ','6.jpg',2,2,17);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(7,'Acondicionador Pro-V Restauración','Los acondicionadores reformulados de Pantene Pro-V incluyen una tecnología que penetran hasta la raíz ayudando a prevenir el daño.','7.jpg',4,2,16);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(11,'Shampoo Blindaje Platinum con pH bajo','Producto ideal para reparar el cabello dañado por tintura, reflejos o alisado.','11.jpg',5,2,10);

insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(8,'Laca Fijación Extra Firme','El Hair Spray Extra Firme proporciona una fijación flexible resistente a la humedad y no necesita enjuague.','8.jpg',5,3,24);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(9,'Espuma para Rizos Perfectos y definidos Pro-V ','Espuma/mousse para rizos perfectos. Te ayuda a lograr el look que buscas desde la mañana hasta la noche.','9.jpg',4,3,24);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(10,'Gel Ultra Fijador De Larga Duración','Gel de L´Oréal ultra fijación de alta duración Invisi FX. Envase conteniendo 370gr.','10.jpg',6,3,24);

insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(12,'Tintura Excellent 30','Castaño oscuro profundo 30','12.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(13,'Tintura Excellent 4','Castaño 4','13.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(14,'Tintura Excellent 5','Castaño claro 5','14.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(15,'Tintura Excellent 7.11','Rubio ceniza profundo 7.11','15.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(16,'Tintura Excellent 8.11','Rubio claro ceniza profundo 8.11','16.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(17,'Tintura Excellent 6.34','Rubio oscuro chocolate 6.34','17.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(18,'Tintura Excellent 9','Rubio muy claro 9','18.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(19,'Tintura Excellent 7','Rubio 7','19.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(20,'Tintura Casting 550','550 Caoba ','20.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(21,'Tintura Casting 200','200 Negro','21.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(22,'Tintura Casting 210','210 Negro azulado','22.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(23,'Tintura Casting 710','710 Rubio glace','23.jpg',6,4,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(24,'Tintura Casting 670','670 Caramelo','24.jpg',6,4,10);

insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(25,'Loción tónica Revitalizante','Tónico Revitalizante refresca la piel, preparandola óptimamente para la aplicación de una crema de día o noche.','25.jpg',1,1,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(26,'Exfoliante Oatmeal Scrub & Mask','Las propiedades calmantes de la avena y la miel nos inspiraron para crear un exfoliante que se puede usar como una mascarilla facial.','26.jpg',7,1,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(27,'Agua Micelar en Aceite','Este producto desmaquilla, limpia y además nutre la piel.','27.jpg',8,1,10);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(28,'Espuma De Afeitar Foamy Piel Sensible ','Este producto ofrece una fragancia suave para la piel sensible. Con su fórmula se esparce y enjuaga con facilidad para una afeitada más suave.','28.jpg',9,1,36);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(29,'Espuma de Afeitar Extra Hidratante','Experimenta un afeitado suave y sin tensión. Con la avanzada tecnología Ultra Glide™ y Aloe Vera.','29.jpg',1,1,26);
insert into Productos (producto_id,nombre,descripcion,imagen,marca_id,categoria_id,stock) values(30,'Gel de Afeitar Sensitive','Para hombres con piel muy sensible propensa al enrojecimiento después del afeitado.','30.jpg',1,1,31);