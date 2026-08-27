# BelajarHijaiyah 📖

Aplikasi Android edukatif untuk belajar **Huruf Hijaiyah** beserta tanda bacanya secara interaktif, dilengkapi dengan kuis bersuara dan pelacakan skor.

---

## ✨ Fitur

- 🔤 **Belajar Huruf Hijaiyah** — Pelajari 28 huruf hijaiyah beserta audio pengucapannya
- 🎵 **Audio Interaktif** — Setiap huruf dan soal kuis dilengkapi suara
- 📚 **7 Kategori Materi**, meliputi:

  | Kategori | Keterangan |
  |---|---|
  | Hijaiyah | Huruf dasar hijaiyah (ا s/d ي) |
  | Fathah | Huruf dengan harakat fathah ( َ ) |
  | Kasroh | Huruf dengan harakat kasroh ( ِ ) |
  | Dhommah | Huruf dengan harakat dhommah ( ُ ) |
  | Fatain | Huruf dengan tanwin fathah ( ً ) |
  | Kastain | Huruf dengan tanwin kasroh ( ٍ ) |
  | Dotain | Huruf dengan tanwin dhommah ( ٌ ) |

- 🧠 **Kuis Interaktif** — 5 soal pilihan ganda per kategori dengan shuffling soal dan jawaban menggunakan algoritma **Fisher-Yates**
- 🏆 **Pelacakan Skor** — Skor per sesi dan total skor tersimpan secara persisten
- 🎶 **Musik Latar** — Background music yang dapat dikelola dengan `MediaPlayer`
- 🌙 **Fullscreen Landscape** — Tampilan landscape penuh tanpa status bar/navigation bar

---

## 🏗️ Arsitektur & Struktur Proyek

```
app/src/main/java/com/example/belajarhijaiyah/
│
├── BaseQuizActivity.java          # Abstract base class untuk semua layar kuis
├── BaseLearningActivity.java      # Abstract base class untuk semua layar belajar
│
├── SplashActivity.java            # Layar splash (entry point)
├── MainActivity.java              # Menu utama
├── LearnActivity.java             # Menu pilih kategori belajar
├── QuizMenuActivity.java          # Menu pilih kategori kuis
├── QuizScoreActivity.java         # Layar rekap skor
├── MusicService.java              # Service untuk background music
├── LetterItem.java                # Model data huruf
│
├── belajar/                       # Layar belajar per kategori (extends BaseLearningActivity)
│   ├── HijaiyahLearningActivity.java
│   ├── FathahLearningActivity.java
│   ├── KasrohLearningActivity.java
│   ├── DhommahLearningActivity.java
│   ├── FatainLearningActivity.java
│   ├── KastainLearningActivity.java
│   └── DhotainLearningActivity.java
│
├── kuis/                          # Layar kuis per kategori (extends BaseQuizActivity)
│   ├── HijaiyahQuizActivity.java
│   ├── FathahQuizActivity.java
│   ├── KasrohQuizActivity.java
│   ├── DhommahQuizActivity.java
│   ├── FatainQuizActivity.java
│   ├── KastainQuizActivity.java
│   └── DotainQuizActivity.java
│
└── constant/
    ├── Constants.java             # Konstanta global (skor, SharedPreferences keys, dll.)
    └── QuizData.java              # Data soal kuis semua kategori (String[][])
```

### Pola Desain

Aplikasi menggunakan pola **Template Method** melalui dua abstract base class:

**`BaseQuizActivity`** — Subclass hanya perlu mengimplementasikan dua method:
```java
protected abstract int getLayoutId();        // Layout XML yang digunakan
protected abstract String[][] getQuizData(); // Data soal dari QuizData.*
```

**`BaseLearningActivity`** — Pola yang sama untuk layar belajar.

Pendekatan ini menghilangkan duplikasi kode yang sebelumnya ada di 14 Activity (7 belajar + 7 kuis).

---

## 🔀 Algoritma Fisher-Yates Shuffle

Soal kuis dan pilihan jawaban diacak menggunakan implementasi **Fisher-Yates** untuk memastikan distribusi yang benar-benar acak dan seragam:

```java
private <T> void fisherYatesShuffle(ArrayList<T> list) {
    Random random = new Random();
    for (int i = list.size() - 1; i > 0; i--) {
        int j = random.nextInt(i + 1);
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
```

- **Urutan soal** diacak saat inisialisasi kuis
- **Pilihan jawaban** diacak per soal sehingga jawaban benar tidak selalu di posisi yang sama

---

## 🛠️ Tech Stack

| Komponen | Detail |
|---|---|
| Bahasa | Java |
| Min SDK | API 21 (Android 5.0 Lollipop) |
| Target SDK | API 35 (Android 15) |
| Build System | Gradle |
| UI | XML Layouts + ViewBinding |
| Audio | `MediaPlayer` + `SoundPool` |
| Persistensi | `SharedPreferences` |
| Animasi | Custom fade-in / fade-out (`res/anim/`) |

### Dependencies

```groovy
implementation 'androidx.appcompat:appcompat:1.7.0'
implementation 'androidx.constraintlayout:constraintlayout:2.2.1'
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'de.hdodenhof:circleimageview:3.1.0'
implementation 'com.google.android.material:material:1.12.0'
```

---

## 🚀 Cara Menjalankan

### Prasyarat
- Android Studio (Hedgehog atau lebih baru)
- JDK 11+
- Android SDK dengan API 35 terpasang

### Langkah

1. Clone repository ini:
   ```bash
   git clone https://github.com/Irfankurni/BelajarHijaiyah.git
   ```
2. Buka project di **Android Studio**
3. Biarkan Gradle sync selesai
4. Jalankan di emulator atau perangkat fisik (orientasi landscape)

---

## 📁 Struktur Data Soal

Setiap baris di `QuizData.java` mengikuti format:

```
{ "audio_resource_name", "correct_answer", "choice_2", "choice_3", "choice_4" }
```

Contoh:
```java
{"kuis_alif", "ا", "ج", "د", "ح"}
```

---

## 📄 Lisensi

Project ini dibuat untuk keperluan edukatif.

---

> Dibuat dengan ❤️ oleh [Irfan Kurniawan](https://github.com/Irfankurni)
