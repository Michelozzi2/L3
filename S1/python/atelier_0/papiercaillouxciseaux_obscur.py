import random

cpo = input("Voulez-vous jouer contre l'ordinateur (Max 5 parties) O/N ? " )
cpo = cpo.capitalize()

if cpo != 'O' :
    if cpo != 'N' :
        print("Je n'ai pas compris votre réponse")

if cpo == 'O':
    nomUn = input("Quel est votre nom ? ")
    print("Bienvenu ",nomUn, " nous allons jouer ensemble \n")
    nomDeux = 'Machine'

scoreUn = 0
manches = 0
if cpo == 'N':
    nomUn = input("Quel est votre nom ? ")
    print("Bienvenu ",nomUn, " nous allons jouer ensemble")
    nomDeux = input("Quel est le nom du deuxième joueur ?")
    print("Bienvenu ",nomDeux, " nous allons jouer ensemble \n")

choix = True
scoreDeux = 0
while choix == True:
    manches += 1 
    choixUn = input("{nom} faîtes votre choix parmi (pierre, papier, ciseaux, puit): ".format(nom=nomUn)).lower()
    if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit' :
        choixUn_ok = False
        while choixUn_ok == False :
            print("Je n'ai pas compris votre réponse")
            print("Joueur ", nomUn)
            choixUn = input("   faîtes votre choix parmi (pierre, papier, ciseaux, puit): ")
            choixUn_ok = True
            if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit' :
                choixUn_ok = False

    if cpo == 'O' : 
        #Ici il faudrait plutôt vérifier que cpo == 'O' autrement
        #il y a un problème si le joueur 2 s'appelle Machine !
        choixDeux = ['papier','pierre','ciseaux', 'puit'][random.randint(0, 3)]


    if nomDeux != 'Machine':
        print("Joueur", nomDeux)
        choixDeux = input("faîtes votre choix parmi (pierre, papier, ciseaux, puit): ").lower()
        if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit' :
            choixDeux_ok = False
            while not choixDeux_ok :
                print("Je n'ai pas compris votre réponse")
                print("Joueur ", nomDeux)
                choixDeux = input(" faîtes votre choix parmi (pierre, papier, ciseaux): ")
                choixDeux_ok = True
                if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit' :
                    choixDeux_ok = False

    #On affiche les choix de chacun
    print("Si on récapitule :",nomUn, choixUn, "et", nomDeux, choixDeux,"\n")


    #On regarde qui a gagné cette manche on calcule les points et on affiche le résultat
    winner= ""
    if choixUn == 'pierre' and choixDeux == 'papier' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1

    if choixUn == 'pierre' and choixDeux == 'pierre' :
        winner = "aucun de vous, vous être ex æquo"
            
    if choixUn == 'pierre' and choixDeux == 'ciseaux' :
        winner = nomUn
        scoreUn = scoreUn + 1
        
    if choixUn == 'pierre' and choixDeux == 'puit' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1




    if choixUn == 'papier' and choixDeux == 'papier' :
        winner = "aucun de vous, vous être ex æquo"
        

    if choixUn == 'papier' and choixDeux == 'ciseaux' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1
       
    if choixUn == 'papier' and choixDeux == 'pierre' :
        winner = nomUn
        scoreUn = scoreUn + 1
    
    if choixUn == 'papier' and choixDeux == 'puit' :
        winner = nomUn
        scoreUn = scoreUn + 1
       




    if choixUn == 'ciseaux' and choixDeux == 'pierre' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1
        

    if choixUn == 'ciseaux' and choixDeux == 'ciseaux' :
        winner = "aucun de vous, vous être ex æquo"
        
        
    if choixUn == 'ciseaux' and choixDeux == 'papier' :
        winner = nomUn
        scoreUn = scoreUn + 1
            

    if choixUn == 'ciseaux' and choixDeux == 'puit' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1





    if choixUn == 'puit' and choixDeux == 'papier' :
        winner = nomDeux
        scoreDeux = scoreDeux + 1
        

    if choixUn == 'puit' and choixDeux == 'pierre' :
        winner = nomUn
        scoreUn = scoreUn + 1
        
    
    if choixUn == 'puit' and choixDeux == 'ciseaux' :
        winner = nomUn
        scoreUn = scoreUn + 1
          

    if choixUn == 'puit' and choixDeux == 'puit' :
        winner = "aucun de vous, vous être ex æquo"
        


    print("le winner est",winner)
    print("Les scores à l'issue de cette manche sont donc",nomUn, scoreUn, "et", nomDeux, scoreDeux, "\n")


    if manches ==5:
        choix = False

        
    if manches < 5:
        #On propose de choix ou de s'arrêter 
        autre_partie = input("Souhaitez vous refaire une partie {} contre {} ? (O/N) ".format(nomUn,nomDeux))
        autre_partie = autre_partie.capitalize()
        if autre_partie == 'O':
            choix = True
        if autre_partie == 'N':
            choix = False
        if autre_partie != 'O' and autre_partie != 'N':
            choix = True
            print("Vous ne répondez pas à la question, on continue ")
  
        
if choix == False :
    print("Merci d'avoir joué ! A bientôt")