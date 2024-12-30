import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.app2.R
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private val requestCodeLocation = 2

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = true
        webView.webViewClient = WebViewClient()
        webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        // Request location permissions
        requestLocationPermissions()

        // Set up fingerprint authentication
        authenticateUser()
    }

    private fun requestLocationPermissions() {
        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, requestCodeLocation)
        }
    }

    private fun authenticateUser() {
        // Executor for handling callbacks
        val executor: Executor = ContextCompat.getMainExecutor(this)

        // BiometricPrompt Authentication Callbacks
        val biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                // Load the WebView after successful authentication
                loadWebApp()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                // Optionally, show a message for failed authentication
                showToast("Authentication failed. Try again.")
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                // Handle errors (e.g., no fingerprint enrolled)
                showToast("Authentication error: $errString")
            }
        })

        // BiometricPrompt Info
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Login with Fingerprint")
            .setSubtitle("Authenticate to access the app")
            .setNegativeButtonText("Cancel")
            .build()

        // Show the fingerprint prompt
        biometricPrompt.authenticate(promptInfo)
    }

    private fun loadWebApp() {
        // Load the local web app after successful authentication
        webView.loadUrl("file:///android_asset/index.html")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            requestCodeLocation -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    showToast("Location permissions granted.")
                } else {
                    // Permission denied
                    showToast("Location permissions denied.")
                }
            }
        }
    }
}
