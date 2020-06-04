alter table `usuario` add (
constraint fk_usuario_pedido foreign key (`pedido_id`) references `pedido`(`id`)
);


alter table `restaurante` add (
constraint fk_restaurante_pedido foreign key (`pedido_id`) references `pedido`(`id`),
constraint fk_restaurante_menu foreign key (`menu_id`) references `menu`(`id`)
);


alter table `pedido` add (
constraint fk_pedido_usuario foreign key (`usuario_id`) references `usuario`(`id`),
constraint fk_pedido_restaurante foreign key (`restaurante_id`) references `restaurante`(`id`),
constraint fk_pedido_item foreign key (`item_id`) references `item`(`id`)
);


alter table `item` add (
constraint fk_item_menu foreign key (`menu_id`) references `menu`(`id`),
constraint fk_item_pedido foreign key (`pedido_id`) references `pedido`(`id`)
);


alter table `menu` add (
constraint fk_menu_restaurante foreign key (`restaurante_id`) references `restaurante`(`id`),
constraint fk_menu_item foreign key (`item_id`) references `item`(`id`)
);