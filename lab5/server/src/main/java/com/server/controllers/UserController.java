package com.server.controllers;

import com.server.network.Request;
import com.server.network.Response;

public class UserController {
    public Response login(Request request) {
        return new Response(false, "Feature in development!", null);
    }

    public Response register(Request request) {
        return new Response(false, "Feature in development!", null);
    }

    public Response getAllUsers() {
        return new Response(false, "Feature in development!", null);
    }

    public Response deleteUser(Request request) {
        return new Response(false, "Feature in development!", null);
    }

    public Response updateEntity(Request request) {
        return new Response(false, "Feature in development!", null);
    }

    public Response readEntity(Request request) {
        return new Response(false, "Feature in development!", null);
    }
}