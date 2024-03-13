/*
1)
Le problème dans ce code est que vous retournez un pointeur vers un tableau local tab de la fonction fonctionX().
 Le tableau tab est alloué sur la pile, et il est automatiquement désalloué lorsque la fonction fonctionX() se termine.
  Par conséquent, le pointeur que vous retournez pointe vers un espace mémoire qui n'est plus valide, 
  ce qui peut entraîner des comportements indéfinis lorsque vous essayez d'accéder à ce tableau dans la fonction main().

Pour résoudre ce problème, vous pouvez allouer le tableau dynamiquement à l'aide de malloc ou calloc dans la fonction fonctionX().
 De cette façon, le tableau ne sera pas désalloué lorsque la fonction se termine, et vous pourrez y accéder en toute sécurité dans la fonction main().

2)
 Le problème dans ce code est similaire au précédent : vous retournez un pointeur vers une variable locale x de la fonction fun().
  La variable x est allouée sur la pile, et elle est automatiquement désallouée lorsque la fonction fun() se termine. Par conséquent, 
  le pointeur que vous retournez pointe vers un espace mémoire qui n'est plus valide, 
  ce qui peut entraîner des comportements indéfinis lorsque vous essayez d'accéder à cette variable dans la fonction main().

3)
Le problème dans ce code est que vous assignez à ptr l'adresse d'une variable locale ch qui est définie dans un bloc de code.
 La variable ch est allouée sur la pile, et elle est automatiquement désallouée lorsque le bloc de code dans lequel elle est définie se termine. 
 Par conséquent, lorsque vous essayez d'accéder à la valeur de *ptr après la fin du bloc de code, vous accédez à un espace mémoire qui n'est plus valide, 
 ce qui peut entraîner des comportements indéfinis.

Pour résoudre ce problème, vous pouvez définir la variable ch en dehors du bloc de code, 
de sorte qu'elle ne soit pas désallouée avant que vous ayez terminé de l'utiliser

4)
Le problème dans ce code est que vous essayez d'assigner une valeur à un pointeur non initialisé piData. 
Le pointeur piData n'a pas été alloué de mémoire, donc il ne pointe vers aucun espace mémoire valide.
 Lorsque vous essayez d'assigner la valeur 10 à *piData, vous essayez d'écrire dans un espace mémoire non valide,
  ce qui peut entraîner des comportements indéfinis, y compris des erreurs d'exécution et des problèmes de sécurité.

Pour résoudre ce problème, vous devez allouer de la mémoire à piData avant d'essayer d'y écrire.
 Vous pouvez le faire en utilisant malloc pour allouer de la mémoire dynamiquement, ou en faisant pointer piData vers une variable existante. 
 Voici comment vous pouvez le faire



*/