package com.codetron.animeku.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codetron.animeku.R
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.Grey
import com.codetron.animeku.ui.theme.White

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Search,
    ),
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    TextField(
        maxLines = 1,
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        label = {
            Text(
                text = stringResource(id = R.string.hint_search),
                color = Grey,
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
                colorFilter = ColorFilter.tint(Grey)
            )
        },
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .clickable { onClick?.invoke() },
    )
}

@Preview
@Composable
fun SearchInput_Preview() {
    AnimeKuTheme {
        SearchInput(value = "", onValueChange = {})
    }
}