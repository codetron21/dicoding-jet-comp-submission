package com.codetron.animeku.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codetron.animeku.R
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.Grey

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    focusRequester: FocusRequester = FocusRequester(),
    leadingIcon: (@Composable () -> Unit)? = {
        Image(
            painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
    },
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Search,
    ),
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    BasicTextField(
        maxLines = 1,
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        cursorBrush = SolidColor(MaterialTheme.colors.primary),
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(Color.White, MaterialTheme.shapes.small)
            .focusRequester(focusRequester)
            .clickable { onClick?.invoke() },
        decorationBox = { innerTextField ->
            Row(
                modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Box(Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.hint_search),
                            color = Grey,
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Preview
@Composable
fun SearchInput_Preview() {
    AnimeKuTheme {
        SearchInput(leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }, value = "tes", onValueChange = {})
    }
}