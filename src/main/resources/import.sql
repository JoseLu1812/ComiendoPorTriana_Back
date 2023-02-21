

insert into user_entity (account_non_expired, account_non_locked, created_at, credentials_non_expired, email, enabled, full_name, last_password_change_at, password, username, id) values ( true, true, '2023-01-31', true, 'jlhn@gmail.com', true, 'José Luis Hidalgo Navas', '2023-02-01', '{bcrypt}$2a$12$MDdQ80jBSFBCzQy1EUrrGeXjZ6VpHGTrML8AUPbVdoMgHZxOYlNMO', 'Joseluhn', '53395e14-60d3-46d8-804f-fafd86c72a19'); --Contra: Master_1812
insert into user_roles (user_id, roles) values ('53395e14-60d3-46d8-804f-fafd86c72a19', 1);

insert into user_entity (account_non_expired, account_non_locked, created_at, credentials_non_expired, email, enabled, full_name, last_password_change_at, password, username, id) values ( true, true, '2023-02-01', true, 'fjdn@gmail.com', true, 'Francisco José Domínguez Navas', '2023-02-01', '{bcrypt}$2a$12$yQyiJvrPoU4K5TfRG7UpVOdjDm36APuJFk6XpywwEq.9XsV3aWDam', 'Franjdn', 'c8d2cf0d-1868-4ced-892a-27bea770def6'); --Contra: Triana_123
insert into user_roles (user_id, roles) values ('c8d2cf0d-1868-4ced-892a-27bea770def6', 2);

insert into user_entity (account_non_expired, account_non_locked, created_at, credentials_non_expired, email, enabled, full_name, last_password_change_at, password, username, id) values ( true, true, '2023-02-02', true, 'jeh@gmail.com', true, 'Julia Estévez Hidalgo', '2023-02-02', '{bcrypt}$2a$12$CPcJtGCLIQzdNqkbSSfnzebwvMnIDgiY0IQ5QZwqkc8ncCXyCFG4u', 'Juliaeh', 'd9554666-0096-469d-96c2-eb20e31dcb23'); --Contra: Cordoba_123
insert into user_roles (user_id, roles) values ('d9554666-0096-469d-96c2-eb20e31dcb23', 2);

insert into user_entity (account_non_expired, account_non_locked, created_at, credentials_non_expired, email, enabled, full_name, last_password_change_at, password, username, id) values ( true, true, '2023-02-03', true, 'mpnt@gmail.com' true, 'María del Pilar Navas Tenor', '2023-02-03', 'Mairena_123', 'MPilarnt', '9d6076d7-233d-4111-bd19-1c589d2a2764');
insert into user_roles (user_id, roles) values ('9d6076d7-233d-4111-bd19-1c589d2a2764', 3);


insert into bar (created_at , description , direction , images , name, owner_id, id) values ( '2023-02-05', 'Bar de toda la vida al más puro estilo sevillano. Caracterizado por sus serranitos, también destacar su alioli y su flamenquín.', 'C/Justino Matute, 6', 'images', 'Bar Cibeles 2', 'c8d2cf0d-1868-4ced-892a-27bea770def6', '80adfa7a-6a63-42f3-8a1e-153039544e7b');
insert into bar (created_at , description , direction , images , name, owner_id, id) values ( '2023-02-06', 'Este clásico bar trianero lleva desde 1970 sirviendo codornices fritas y adobadas y son los pajaritos más celebrados de toda Sevilla.', 'Avenida Santa Cecilia, 2', 'images', 'Bar Ruperto', 'd9554666-0096-469d-96c2-eb20e31dcb23', 'c2dde920-80df-4743-86d4-3545269edcb7');


insert into favoritos (bar_id , user_id) values ( '80adfa7a-6a63-42f3-8a1e-153039544e7b', '9d6076d7-233d-4111-bd19-1c589d2a2764');

insert into comment (created_at, text, title, author, bar, id) values ( '2023-02-15', 'Muy buen lugar y quede satisfecho.', 'Excelente', '9d6076d7-233d-4111-bd19-1c589d2a2764', 'c2dde920-80df-4743-86d4-3545269edcb7' ,'b93efc37-15ef-4945-8552-9ca37a971761');



--
--
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( a4993c76-a232-442f-ab71-dd3e0342de96, 'AgEntRen', '@E@pgK75av', 'agp@email.com', 'Adolfo García Perez', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 5cbdc9a6-abb7-4b8d-9766-6edc374ed096, 'rENteRLe', 'eMe1_@7dmQ', 'pmm@email.com', 'Paola Madrid Morata', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 117b5abd-b3e2-4b5e-a12a-f02b76204aee, 'hINglING', 'Ct7cF9_fXp', 'smc@email.com', 'Sebastian Mateo Casals', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 683cf076-0f88-4838-8e4f-91de1a78cfae, 'MSBIaLWa', '_Wz4AhD7O3', 'yrv@email.com', 'Yolanda Riera-Vidal', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 12b34a1e-fdbf-4aa6-8ee6-a441b2312193, 'AwaciCha', '!odLg4XLg8', 'nec@email.com', 'Néstor Escudero Calatayud', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( bbc620d2-b534-4e6f-91bf-8163a164df43, 'OUsTiLan', 'ugjsh5!XGG', 'agf@email.com', 'Antonia Galiano Frías', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 11e2191e-2056-43e7-be3b-b9b77066739e, 'anbElEyE', 'Zgnk4@GU9r', 'pfp@email.com', 'Pedro Ferrer Peiró', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 323cddc9-09a1-4107-8e6d-9199aa2f7baf, 'ANgTAtrO', 'yjF_o9X_pE', 'rcm@email.com', 'Roque Cruz Manzanares', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 9f771c2e-01b0-4fe1-adb7-45aa09eb4c1e, 'GLAndALV', 'v3Ct@mk5_J', 'omh@email.com', 'Óscar Malo Hernandez', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( e31194db-3c18-47a5-bfdb-172ceebf7660, 'tOMpOloy', 'AX5@r2FGxD', 'pss@email.com', 'Pilar Serna Salazar', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( e70c9108-ddcf-416b-a957-01feed566a64, 'couNorIs', 'xzFt7pjJR@', 'afm@email.com', 'Amalia Fuster Mata', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 062a6a92-98eb-43c8-bbc0-4089b36962a4, 'psiMPInu', '@OdwAUz_3_', 'ndf@email.com', 'Nacho Dominguez Fuentes', true, true, true, true, '2023-01-31','2023-02-01' );

--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( d5794d4c-bd38-4f6d-8462-056072d881d4, 'EANKleoP', 'iP5xyw!Yjy', 'amb@email.com', 'Ainoa Meléndez Bayo', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( fb36c6a8-ea13-408e-8646-146838dae8ac, 'NtIveROn', 'nm!kQ3_HYX', 'bnp@email.com', 'Blas Novoa Plana', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( cd728c15-3f48-4104-994b-956560e52f82, 'ApAuTaBe', 'dMH_09hu26', 'alar@email.com', 'Ángela García Pérez', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( b4b2af1f-cbfa-4f2e-8039-33b522f4e211, 'rSHENCER', 'fu9Tz4@O2k', 'ngt@email.com', 'Nuria Gallego Trujillo', true, true, true, true, '2023-01-31','2023-02-01');
--insert into user (id, username, password, email, full_name, account_non_locked, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at) values ( 9d6076d7-233d-4111-bd19-1c589d2a2764, 'Pilarnt', 'Triana2023"', 'mpnt@gmail.com', 'María del Pilar Navas Tenor', true, true, true, true, '2023-01-31','2023-02-01');
--
--
--insert into bar (id, name, description, direction, owner, images, created_at) values ( c2dde920-80df-4743-86d4-3545269edcb7, 'Casa Ruperto', 'Este clásico bar trianero lleva desde 1970 sirviendo codornices fritas y adobadas y son los 'pajaritos' más celebrados de toda Sevilla.', 'Avenida Santa Cecilia, 2', 683cf076-0f88-4838-8e4f-91de1a78cfae, 'imagen', '2023-01-05');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( db1ac247-571a-43cf-82ce-411728783c07, 'Bar Casa Casimiro', 'Tienen una carta amplia en las que se incluye: croquetas, huevos de chocos, flamenquín, solomillo al whisky, filete de pollo bechamel, entre otras.', 'Avenida de Coria, 19', c8d2cf0d-1868-4ced-892a-27bea770def6, 'imagen', '2023-02-11');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 464f01c6-7f8b-4afb-b9ba-44fdf9db9631, 'Trianilla', 'Su amplia carta tiene manjares tales como: ensaladilla de pulpo, coca de gorgonzola, dados de atún rojo sobre pan, puntas de solomillo ibérico y hamburguesa de ternera black angus...', 'C/Manuel Pareja Obregón, 2', a4993c76-a232-442f-ab71-dd3e0342de96, 'imagen', '2023-01-25');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( ae6d3c89-07ae-4e73-ad79-97148ca40158, 'Bar Salomón Rey de los Pinchitos', 'Aquí la especialidad de la casa son los pinchitos, como su nombre bien indica. Hay tapas y raciones para degustar tanto en el salón como en la terraza.', 'López de Gómara, 11', 5cbdc9a6-abb7-4b8d-9766-6edc374ed096, 'imagen', '2023-01-16');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 625cd031-1a54-4d3d-a6bc-b835909fa18e, 'Café Bar Altozano de Triana', 'Es de los bares clásicos del barrio y su comida más clásica todavía. Destaca sin duda por sus tortillitas de camarones, el adobo y las coquinas. Es imposible que este bar defraude a alguien.', 'C/San Jacinto, 4', 117b5abd-b3e2-4b5e-a12a-f02b76204aee, 'imagen', '2023-02-14');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 3bb95209-da68-4f55-9eed-ba0001a1ad3c, 'Blanca Paloma', 'De los mejores lugares trianeros con diferencia. No es baratísimo pero merece mucho la pena por algunas de las exquisiteces que puedes tomar. Además dentro de la comida clásica suelen ser innovadores.', 'C/San Jacinto, 49', 12b34a1e-fdbf-4aa6-8ee6-a441b2312193, 'imagen', '2023-02-02');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( bf260a9b-3438-4067-b3d2-030b782b1388, 'Victoria 8', 'Lugar recomendadísimo en todos los sentidos. El local está bien decorado y es acogedor. No hay una gran variedad pero eso es lo de menos, porque lo compensa con creces sus tataki de atún y sus croquetas de rabo de toro.', 'C/Victoria, 8', bbc620d2-b534-4e6f-91bf-8163a164df43, 'imagen', '2023-01-08');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 9f26b992-027b-4290-8851-34bc5c40e36f, 'Sol y sombra', 'Otro tipiquísimo lugar del barrio de los que huelen a queso curado y jamón. Hay una gran variedad de tapas y de precio es más que correcto.', 'C/Castilla, 151', 11e2191e-2056-43e7-be3b-b9b77066739e, 'imagen', '2023-02-09');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 7055f932-a1ea-4fe7-a4b2-0da9a871f644, 'Vega 10', 'El macarrón toro, las arepas y la pastela son algunas de las mejores comidas del lugar, por no hablar de los postres. Dejad un hueco (aunque sea complicado) para el cremoso de azafrán.', 'C/Vega, 10', 11e2191e-2056-43e7-be3b-b9b77066739e, 'imagen', '2023-02-01');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( a7b81431-43a1-4e72-8685-3647f12b3047, 'Maria Trifulca', 'Aunque solo sea por sus espectaculares vistas, bien merece la pena incluirlo en esta lista. Ubicado en el antiguo faro de Triana, Maria Trifulca es una comida de lujo sobre el Guadalquivir y la opción perfecta para ocasiones especiales.', 'Puente de Triana, Plaza del Altozado, esquina', 323cddc9-09a1-4107-8e6d-9199aa2f7baf, 'imagen', '2023-01-24');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( bf7c2b27-6396-4abf-8eed-b93933290621, 'Taberna Miami', 'Una taberna donde comer en Triana de tapas o de raciones sentado en su terraza. No te pierdas el adobo, las acedías o el secreto. También recomiendan las bandejas de pescaito frito, el rabo de toro y el arroz negro.', 'C/San Jacinto, 21', 323cddc9-09a1-4107-8e6d-9199aa2f7baf, 'imagen', '2023-01-30');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( e0469d55-f941-44d0-93ae-1ffed49d300c, 'Casa Diego', 'Una tasca tradicional de las más típicas y uno de los mejores bares de tapas en Triana. Comida casera, con buenas raciones y de calidad.', 'C/Calle Alfarería, 5', 9f771c2e-01b0-4fe1-adb7-45aa09eb4c1e, 'imagen', '2023-02-10');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 912b2cb8-389f-408a-889d-95ea65250e67, 'Patio de San Eloy', 'Un lugar emblemático donde tomar algo, también imprescindible en el top ten de bares y restaurantes donde comer de tapas en Triana bien y barato.', 'C/San Jacinto, 16', e31194db-3c18-47a5-bfdb-172ceebf7660, 'imagen', '2023-01-15');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( a8046137-373a-40a7-85f3-8d5f241bbceb, 'Freiduría Reina Victoria', 'Incluimos esta freiduría entre las recomendaciones para comer de tapas en Triana bien y barato, tal y como nos la dieron.', 'C/Rodrigo de Triana, 51', e31194db-3c18-47a5-bfdb-172ceebf7660, 'imagen', '2023-01-19');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 63d502f3-3c5e-4eef-ae9c-21840e243faf, 'Río Grande', 'Cuidada restauración tradicional en plena la calle Betis, con unas vistas de Sevilla excepcionales. Zona de restaurante más formal o terraza más distendida, una de las mejores de Sevilla. Carta amplia, con opción vegana o menú degustación.', 'C/Betis, 69', 53395e14-60d3-46d8-804f-fafd86c72a19, 'imagen', '2023-02-14');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( a3c714bb-8588-4591-a7d1-3fa058304c9c, "Abades Triana", "Muy versátil, su moderna carta se adapta tanto a cenas románticas como comidas de empresa, como tener la posibilidad de tomarte una copa etc sin perder ni un ápice en modernidad o calidad en el servicio.", 'C/Betis, 69', 53395e14-60d3-46d8-804f-fafd86c72a19, 'imagen', '2023-02-18');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( 80adfa7a-6a63-42f3-8a1e-153039544e7b, 'Bar Cibeles 2', 'Bar de toda la vida al más puro estilo sevillano. Caracterizado por sus serranitos, también destacar su alioli y su flamenquín.', 'C/Justino Matute, 6', d9554666-0096-469d-96c2-eb20e31dcb23, 'imagen', '2023-01-01');
--insert into bar (id, name, description, direction, owner, images, created_at) values ( b8ccde1e-59c7-4245-8e13-264e76beb728, 'Restaurante Por la boca muere el pez tapas', 'Destacada por sus terrazas interior y exterior, y a su vez por el trato al personal, consta de una amplia y exquisita carta, donde se recomienda la ensaladilla y croquetas de rabo de toro.', 'C/ López de Gómara, 59', 062a6a92-98eb-43c8-bbc0-4089b36962a4, 'imagen', '2023-01-10');
--
--
--
--
--
--insert into favoritos(bar_id, user_id) values ( c2dde920-80df-4743-86d4-3545269edcb7, d9554666-0096-469d-96c2-eb20e31dcb23);
--insert into favoritos(bar_id, user_id) values ( 464f01c6-7f8b-4afb-b9ba-44fdf9db9631, d9554666-0096-469d-96c2-eb20e31dcb23);
--insert into favoritos(bar_id, user_id) values ( 3bb95209-da68-4f55-9eed-ba0001a1ad3c, d9554666-0096-469d-96c2-eb20e31dcb23);
--insert into favoritos(bar_id, user_id) values ( b8ccde1e-59c7-4245-8e13-264e76beb728, d9554666-0096-469d-96c2-eb20e31dcb23);
--insert into favoritos(bar_id, user_id) values ( 9f26b992-027b-4290-8851-34bc5c40e36f, d5794d4c-bd38-4f6d-8462-056072d881d4);
--insert into favoritos(bar_id, user_id) values ( 912b2cb8-389f-408a-889d-95ea65250e67, d5794d4c-bd38-4f6d-8462-056072d881d4);
--insert into favoritos(bar_id, user_id) values ( c2dde920-80df-4743-86d4-3545269edcb7, d5794d4c-bd38-4f6d-8462-056072d881d4);
--insert into favoritos(bar_id, user_id) values ( 63d502f3-3c5e-4eef-ae9c-21840e243faf, d5794d4c-bd38-4f6d-8462-056072d881d4);
--insert into favoritos(bar_id, user_id) values ( a7b81431-43a1-4e72-8685-3647f12b3047, d5794d4c-bd38-4f6d-8462-056072d881d4);
--insert into favoritos(bar_id, user_id) values ( 80adfa7a-6a63-42f3-8a1e-153039544e7b, cd728c15-3f48-4104-994b-956560e52f82);
--insert into favoritos(bar_id, user_id) values ( 625cd031-1a54-4d3d-a6bc-b835909fa18e, cd728c15-3f48-4104-994b-956560e52f82);
--insert into favoritos(bar_id, user_id) values ( 7055f932-a1ea-4fe7-a4b2-0da9a871f644, b4b2af1f-cbfa-4f2e-8039-33b522f4e211);
--insert into favoritos(bar_id, user_id) values ( a8046137-373a-40a7-85f3-8d5f241bbceb, b4b2af1f-cbfa-4f2e-8039-33b522f4e211);
--insert into favoritos(bar_id, user_id) values ( db1ac247-571a-43cf-82ce-411728783c07, b4b2af1f-cbfa-4f2e-8039-33b522f4e211);
--insert into favoritos(bar_id, user_id) values ( 63d502f3-3c5e-4eef-ae9c-21840e243faf, 9d6076d7-233d-4111-bd19-1c589d2a2764);
--insert into favoritos(bar_id, user_id) values ( 3bb95209-da68-4f55-9eed-ba0001a1ad3c, 9d6076d7-233d-4111-bd19-1c589d2a2764);
--insert into favoritos(bar_id, user_id) values ( 464f01c6-7f8b-4afb-b9ba-44fdf9db9631, 9d6076d7-233d-4111-bd19-1c589d2a2764);
--insert into favoritos(bar_id, user_id) values ( bf7c2b27-6396-4abf-8eed-b93933290621, 9d6076d7-233d-4111-bd19-1c589d2a2764);
--insert into favoritos(bar_id, user_id) values ( b8ccde1e-59c7-4245-8e13-264e76beb728, 9d6076d7-233d-4111-bd19-1c589d2a2764);
--
--
--
--
--insert into comment (id, text, title, author, bar, created_at) values ( , "", "", , , );
--
--
--
--
--
--
--
