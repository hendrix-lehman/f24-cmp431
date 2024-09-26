package com.example.autoloancalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.autoloancalculator.ui.theme.AutoLoanCalculatorTheme
import kotlin.math.pow
import kotlin.math.round

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AutoLoanCalculatorTheme {
        AutoLoanCalculatorApp()
      }
    }
  }
}

@SuppressLint("DefaultLocale")
@Preview
@Composable
fun AutoLoanCalculatorApp() {
  var loanAmount by remember { mutableStateOf("") }
  var interestRate by remember { mutableStateOf("") }
  var loanTerm by remember { mutableStateOf("") }
  var monthlyPayment by remember { mutableStateOf("0.00") }

  Scaffold(
    topBar = {
      AppHeader()
    },
  ) { innerPadding ->

    Surface(
      modifier = Modifier.fillMaxSize()
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
          .statusBarsPadding()
          .verticalScroll(rememberScrollState())
          .safeDrawingPadding()
          .padding(horizontal = 40.dp)
          .padding(innerPadding)
      ) {
        EditNumberField(
          modifier = Modifier.padding(bottom = 32.dp),
          value = loanAmount,
          onValueChange = { loanAmount = it },
          label = stringResource(R.string.loan_amount),
          icon = {
            Icon(
              painterResource(R.drawable.baseline_attach_money_24),
              stringResource(R.string.loan_amount),
            )
          },
        )
        EditNumberField(
          modifier = Modifier.padding(bottom = 32.dp),
          value = interestRate,
          onValueChange = { interestRate = it },
          label = stringResource(R.string.interest_rate_label),
          icon = {
            Icon(
              painterResource(R.drawable.baseline_percent_24),
              stringResource(R.string.interest_rate_label),
            )
          },
        )
        EditNumberField(
          modifier = Modifier.padding(bottom = 32.dp),
          value = loanTerm,
          label = stringResource(R.string.loan_term_label),
          icon = {},
          // lambda function to update loanTerm
//          onValueChange = { value -> loanTerm = value }
          // you can omit the argument name and refer to it as `it`
          onValueChange = { loanTerm = it },
        )

        Button(onClick = {
          monthlyPayment = calculateMonthlyPayment(
            loanAmount.toDouble(), interestRate.toDouble(), loanTerm.toInt()
          ).toString()
        }) {
          Text(stringResource(R.string.calculate))
        }

        Text(
          text = "Monthly Payment: $ ${monthlyPayment}", modifier = Modifier.padding(top = 32.dp)
        )
      }
    }
  }
}

fun calculateMonthlyPayment(loanAmount: Double, interestRate: Double, loanTerm: Int): Double {
  // monthly payment = (loanAmount) * (interestRate / 12) / (1 - (1 + interestRate / 12)^(-loanTerm * 12))
  val interest = interestRate / 100 / 12
  val monthlyPayment = loanAmount * (interest / (1 - (1 + interest).pow(-loanTerm.toDouble())))
  return round(monthlyPayment)
}

fun greeting(name: String): String {

  if (name.isEmpty()) {
    return "Hello!"
  }
  return "Hello ${name}!"
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    title = { Text(stringResource(R.string.app_name)) },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      titleContentColor = MaterialTheme.colorScheme.primary,
    ),
  )
}

@Composable
fun EditNumberField(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit,
  label: String = "",
  icon: @Composable (() -> Unit)?,
) {
  TextField(
    value = value,
    label = { Text(text = label) },
    leadingIcon = icon,
    onValueChange = onValueChange,
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    modifier = modifier
  )
}