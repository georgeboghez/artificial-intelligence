
# Laborator 2: Modelarea unei probleme de decizie

## Problema: Avem un labirint nxm, o poziție de start (xs,ys) și o poziție destinație (xd,yd). Găsiți un drum de la poziția de start până la cea destinație. Un pas poate fi făcut sus, jos, stânga sau dreapta doar dacă în acea direcție nu este o barieră sau nu ieșim din labirint. Este posibil ca labirintul să nu aibă drum între poziția de start și cea finală.

### Etape de rezolvare:

- (0.2) Alegeți o reprezentare a unei stări a problemei. Reprezentarea trebuie să fie suficient de explicită pentru a conține toate informaţiile necesare pentru continuarea găsirii unei soluții dar trebuie să fie și suficient de formalizată pentru a fi ușor de prelucrat/memorat.
- (0.2) Identificați stările speciale (inițială și finală) și implementați funcția de inițializare (primește ca parametrii instanța problemei, întoarce starea inițială) și funcția booleană care verifică dacă o stare primită ca parametru este finală.
- (0.2) Implementați tranziția ca o funcție care primește ca parametri o stare și parametrii tranziției și întoarce starea rezultată în urma aplicării tranziției. Validarea tranziției se face într-o funcție booleană separată, cu aceeași parametrii.

### Resurse:
- https://github.com/oppenheimj/maze-generator (folosiți pentru a genera un labirint de test cu cel puțin 100 de căsuțe)
