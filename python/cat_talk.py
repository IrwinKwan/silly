#!/usr/bin/env python
import pygame
from pygame.locals import *


class Cat(pygame.sprite.Sprite):
    def __init__(self, type):
        pygame.sprite.Sprite.__init__(self)

        self.type = type
        self.image = pygame.Surface((20,20))
        self.image.fill(Color("red"))
        self.rect = self.image.get_rect()

        self.position = [55, 55]
        self.rect.center = self.position

    def meow(self):
        print "Meow, I'm a %s." % self.type

    def up(self):
        self.position[1] -= 1

    def down(self):
        self.position[1] += 1

    def update(self):
        self.rect.center = self.position

def main():
    pygame.init()
    screen = pygame.display.set_mode((320,200))
    pygame.display.set_caption('Meow Meow')

    background = pygame.Surface(screen.get_size()).convert()
    background.fill(Color("black"))
    screen.blit(background, (0,0))
    pygame.display.flip()

    cat = Cat("Tabby")
    allsprites = pygame.sprite.RenderPlain(cat)

    clock = pygame.time.Clock()
    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                return
            elif event.type == KEYDOWN and event.key == K_ESCAPE:
                return

        keystate = pygame.key.get_pressed()

        allsprites.update()
        screen.blit(background, (0, 0))
        allsprites.draw(screen)
        pygame.display.flip()

        if keystate[K_UP]:
            cat.up()
        elif keystate[K_DOWN]:
            cat.down()


        clock.tick(30)

    pygame.quit()

if __name__ == "__main__":
    main()
