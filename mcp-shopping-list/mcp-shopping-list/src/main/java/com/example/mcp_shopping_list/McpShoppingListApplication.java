package com.example.mcp_shopping_list;

import org.springframework.ai.chat.messages.AssistantMessage.ToolCall;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ShoppingCart;

@SpringBootApplication
public class McpShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpShoppingListApplication.class, args);
	}
	@Bean
	public List<ToolCallback> tools (ShoppingCart shoppingCart){
		return List.of(ToolCallbacks.from(shoppingCart));
	}

}
