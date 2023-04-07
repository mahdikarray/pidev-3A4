<?php

namespace App\Entity;
use App\Repository\OffreRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: OffreRepository::class)]
class Offre
{
    /**
     * @return int
     */
    public function getIdOffre(): int
    {
        return $this->idOffre;
    }

    /**
     * @param int $idOffre
     */
    public function setIdOffre(int $idOffre): void
    {
        $this->idOffre = $idOffre;
    }

    /**
     * @return string
     */
    public function getDescriptionOf(): string
    {
        return $this->descriptionOf;
    }

    /**
     * @param string $descriptionOf
     */
    public function setDescriptionOf(string $descriptionOf): void
    {
        $this->descriptionOf = $descriptionOf;
    }
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $idOffre=null;

    #[ORM\Column]
    #[Assert\NotBlank(message: 'Description offre doit etre non vide')]
    #[Assert\Length(min: 7, max: 10000, minMessage: 'Doit etre supérieur a 7 caractére .', maxMessage: 'Doit etre inferieure 1000')]
    private ?string $descriptionOf=null;


}
