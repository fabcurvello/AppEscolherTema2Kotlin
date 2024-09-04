package br.com.fabriciocurvello.appescolhertema2kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val THEME_FILE_NAME = "theme_preference.txt"

    private lateinit var tvTema: TextView
    private lateinit var btTemaClaro: Button
    private lateinit var btTemaEscuro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Aplicar o tema antes da tela ser criada
        applySavedTheme()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvTema = findViewById(R.id.tv_tema)
        btTemaClaro = findViewById(R.id.bt_tema_claro)
        btTemaEscuro = findViewById(R.id.bt_tema_escuro)

        updateThemeStatusText()

        btTemaClaro.setOnClickListener {
            setAppTheme(AppCompatDelegate.MODE_NIGHT_NO)
            saveThemePreference("LIGHT")
            updateThemeStatusText()
        }

        btTemaEscuro.setOnClickListener {
            setAppTheme(AppCompatDelegate.MODE_NIGHT_YES)
            saveThemePreference("DARK")
            updateThemeStatusText()
        }

    } // fim do onCreate()

    private fun applySavedTheme() {
        val theme = loadThemePreference()
        if ("DARK" == theme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else if ("LIGHT" == theme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    private fun setAppTheme(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }

    private fun saveThemePreference(theme: String) {
        val file = File(filesDir, THEME_FILE_NAME)
        try {
            FileWriter(file).use { writer ->
                writer.write(theme)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun updateThemeStatusText() {
        val currentMode = AppCompatDelegate.getDefaultNightMode()
        val currentTheme = when (currentMode) {
            AppCompatDelegate.MODE_NIGHT_YES -> "Escuro"
            AppCompatDelegate.MODE_NIGHT_NO -> "Claro"
            else -> "Padrão do Sistema"
        }
        tvTema.text = "Tema Atual: $currentTheme"
    }

    private fun loadThemePreference(): String? {
        val file = File(filesDir, THEME_FILE_NAME)
        if (file.exists()) {
            try {
                FileReader(file).use { reader ->
                    val buffer = CharArray(file.length().toInt())
                    reader.read(buffer)
                    return String(buffer)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return null
    }
}


