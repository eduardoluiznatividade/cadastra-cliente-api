INSERT INTO T_TIPO_LOGRADOURO 	( 	ID_LOGRADOURO 	, SG_ABREVIACAO , DS_ENDERECO 	) 
VALUES							(	1				, 'Av'			, 'Avenida'		),
								(	2				, 'R'			, 'Rua'  		),
								(	3				, 'Tv'    		, 'Travessa'	);


INSERT INTO T_CLIENTE	( NM_CLIENTE	) 
VALUES					('JOSE'			);

						
INSERT INTO T_ENDERECO 
	(
		ID_ENDERECO , ID_LOGRADOURO	, DS_BAIRRO 	, DS_COMPLEMENTO	, NM_LOGRADOURO		, NR_CEP	, NR_LOGRADOURO	, TP_ENDERECO 
	) 
VALUES
	(
		1			, 1				, 'COPACABANA'	, 'APTO'			, 'AV SERNAMBETIBA'	, '1010101'	, '30'			, 'RESIDENCIAL'
	),	
	(	
		2			, 2				, 'LEBLON'		, 'APTO'			, 'AV ATLANTICA'	, '1010201' , '40'			, 'COMERCIAL'
	);